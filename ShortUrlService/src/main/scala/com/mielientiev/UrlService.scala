package com.mielientiev

import org.http4s.rho.RhoService
import org.http4s.rho.swagger._

class UrlService extends RhoService {

  "Just a friendly hello route" ** GET / "hello" |>> { () =>
    Ok("Hello world!")
  }

}
