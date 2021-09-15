package ragnarok

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Ragnarok extends Simulation {

  val httpProtocol = http
    .baseUrl("https://tranquil-temple-33251.herokuapp.com/accounts") // Here is the root for all relative URLs

  val scn = scenario("Chamar partner-account-api")
    .exec(http("request")
      .get("/")
      .check(status.is(200))
    )

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}
