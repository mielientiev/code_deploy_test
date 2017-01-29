package com.mielientiev


import org.http4s.Service
import org.http4s.rho.swagger.SwaggerSupport
import org.http4s.server.{Server, ServerApp}
import org.http4s.server.blaze.BlazeBuilder

import scalaz.concurrent.Task

object ShortUrlApp extends ServerApp {
  private val routes = new UrlService().toService(SwaggerSupport())

  override def server(args: List[String]): Task[Server] =
    BlazeBuilder
      .bindLocal(9000)
      .mountService(Service.withFallback(StaticContentService.routes)(routes))
      .start
}
