package bbc.requests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object NewsRequests {
  val newsList = http("NewsList")
    .get("/news")
    .check(status.is(200))

  val ukPoliticsPost = http("UKPoliticsPost")
    .get("/news/uk-politics-41684111")
    .check(status.is(200))
}
