package cass.web

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction

import org.springframework.web.reactive.function.server.router

fun routes(hotelHandler: HotelHandler): RouterFunction<*> {
    return router {
        ("/hotels" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/{id}", hotelHandler::get)
            POST("/", hotelHandler::save)
            PUT("/", hotelHandler::update)
            DELETE("/{id}", hotelHandler::delete)
            GET("/startingwith/{letter}", hotelHandler::findHotelsWithLetter)
            GET("/fromstate/{state}", hotelHandler::findHotelsInState)
        }
    }
}