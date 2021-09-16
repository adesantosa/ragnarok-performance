package ragnarok

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

class Ragnarok extends Simulation {

  val httpProtocol = http
    .baseUrl("http://sheltered-shelf-55259.herokuapp.com/reactive/accounts") // Here is the root for all relative URLs

  val scn = scenario("Chamar partner-account-api")
    .exec(http("request")
      .get("/")
      .check(status.is(200))
    )

//  setUp(scn.inject(atOnceUsers(17)).protocols(httpProtocol))

  setUp(
    scn.inject(
      atOnceUsers(10), // 2
      constantUsersPerSec(300).during(1.minute), // 4
    ).protocols(httpProtocol)
  )
}
