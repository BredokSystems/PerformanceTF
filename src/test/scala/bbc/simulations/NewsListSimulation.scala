package bbc.simulations

import io.gatling.core.Predef._
import bbc.requests.NewsRequests._
import io.gatling.http.Predef.http

import scala.language.postfixOps
import scala.concurrent.duration._

class NewsListSimulation extends Simulation {
  val httpConf = http.baseURL("http://www.bbc.com")

  val getNewsPageScn = scenario("NewsList").exec(newsList)

  val getUKPoliticsPost = scenario("UKPoliticsPost").exec(ukPoliticsPost)

  setUp(getNewsPageScn.exec(getUKPoliticsPost).inject(rampUsers(40) over(1 seconds)).protocols(httpConf)
    .protocols(httpConf))
}