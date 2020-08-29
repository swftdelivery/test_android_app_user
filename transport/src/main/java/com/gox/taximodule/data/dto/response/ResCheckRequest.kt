package com.gox.taximodule.data.dto.response


data class ResCheckRequest(
        val error: List<Any?>? = listOf(),
        val message: String? = "",
        val responseData: ResponseData? = ResponseData(),
        val statusCode: String? = "",
        val title: String? = ""
) {
    data class ResponseData(
            val `data`: List<Data?>? = listOf(),
            val emergency: List<Emergency?>? = listOf(),
            val sos: String? = ""
    ) {
        data class Emergency(
                val number: String? = ""
        )

        data class Data(
                val admin_id: Any? = Any(),
                val assigned_at: String? = "",
                val assigned_time: String? = "",
                val booking_id: String? = "",
                val calculator: String? = "",
                val cancel_reason: Any? = Any(),
                val cancelled_by: Any? = Any(),
                val city_id: Int? = 0,
                val company_id: Int? = 0,
                val country_id: Any? = Any(),
                val created_at: String? = "",
                val currency: String? = "",
                val d_address: String? = "",
                val d_latitude: Double? = 0.0,
                val d_longitude: Double? = 0.0,
                val destination_log: String? = "",
                val distance: Any? = Any(),
                val finished_at: String? = "",
                val finished_time: String? = "",
                val id: Int? = 0,
                val is_scheduled: String? = "",
                val is_track: String? = "",
                val otp: String? = "",
                val paid: Int? = 0,
                val payment: Payment? = Payment(),
                val chat: Chat? = Chat(),
                val payment_mode: String? = "",
                val peak: Int? = 0,
                val peak_hour_id: Any? = Any(),
                val promocode_id: Int? = 0,
                val provider: Provider? = Provider(),
                val provider_id: Int? = 0,
                val provider_rated: Int? = 0,
                val provider_service_id: Int? = 0,
                val provider_vehicle_id: Int? = 0,
                val rating: Rating? = Rating(),
                val reasons: List<Reason?>? = listOf(),
                val request_type: String? = "",
                val ride: Ride? = Ride(),
                val ride_delivery_id: Int? = 0,
                val ride_otp: Int? = 0,
                val ride_type_id: Any? = Any(),
                val route_key: String? = "",
                val s_address: String? = "",
                val s_latitude: Double? = 0.0,
                val s_longitude: Double? = 0.0,
                val schedule_at: Any? = Any(),
                val schedule_time: String? = "",
                val service_type: ServiceType? = ServiceType(),
                val started_at: String? = "",
                val started_time: String? = "",
                val status: String? = "",
                val surge: Int? = 0,
                val timezone: String? = "",
                val track_distance: Int? = 0,
                val track_latitude: Double? = 0.0,
                val track_longitude: Double? = 0.0,
                val travel_time: String? = "",
                val unit: String? = "",
                val use_wallet: Int? = 0,
                val user: User? = User(),
                val user_id: Int? = 0,
                val user_rated: Int? = 0,
                val vehicle_type: String? = ""
        ) {
            data class ServiceType(
                    val admin_service_id: Int? = 0,
                    val base_fare: String? = "",
                    val category_id: Int? = 0,
                    val company_id: Int? = 0,
                    val id: Int? = 0,
                    val per_miles: String? = "",
                    val per_mins: String? = "",
                    val provider_id: Int? = 0,
                    val provider_vehicle_id: Int? = 0,
                    val ride_delivery_id: Int? = 0,
                    val service_id: Int? = 0,
                    val status: String? = "",
                    val sub_category_id: Int? = 0,
                    val vehicle: Vehicle? = Vehicle()
            ) {
                data class Vehicle(
                        val child_seat: Int? = 0,
                        val company_id: Int? = 0,
                        val id: Int? = 0,
                        val picture: String? = "",
                        val picture1: String? = "",
                        val provider_id: Int? = 0,
                        val vechile_image: Any? = Any(),
                        val vehicle_color: String? = "",
                        val vehicle_make: String? = "",
                        val vehicle_model: String? = "",
                        val vehicle_no: String? = "",
                        val vehicle_service_id: Int? = 0,
                        val vehicle_year: Int? = 0,
                        val wheel_chair: Int? = 0
                )
            }

            data class Ride(
                    val capacity: Int? = 0,
                    val company_id: Int? = 0,
                    val id: Int? = 0,
                    val ride_type_id: Int? = 0,
                    val status: Int? = 0,
                    val vehicle_image: String? = "",
                    val vehicle_marker: String? = "",
                    val vehicle_name: String? = "",
                    val vehicle_type: String? = ""
            )

            data class Reason(
                    val created_by: Int? = 0,
                    val created_type: String? = "",
                    val deleted_by: Any? = Any(),
                    val deleted_type: Any? = Any(),
                    val id: Int? = 0,
                    val modified_by: Int? = 0,
                    val modified_type: String? = "",
                    val reason: String? = "",
                    val service: String? = "",
                    val status: String? = "",
                    val type: String? = ""
            )

            data class Rating(
                    val admin_service_id: Int? = 0,
                    val company_id: Int? = 0,
                    val created_at: String? = "",
                    val created_by: Int? = 0,
                    val created_type: String? = "",
                    val deleted_at: Any? = Any(),
                    val deleted_by: Any? = Any(),
                    val deleted_type: Any? = Any(),
                    val id: Int? = 0,
                    val modified_by: Int? = 0,
                    val modified_type: String? = "",
                    val provider_comment: String? = "",
                    val provider_id: Int? = 0,
                    val provider_rating: Int? = 0,
                    val request_id: Int? = 0,
                    val store_comment: Any? = Any(),
                    val store_id: Any? = Any(),
                    val store_rating: Int? = 0,
                    val updated_at: String? = "",
                    val user_comment: String? = "",
                    val user_id: Int? = 0,
                    val user_rating: Int? = 0
            )

            data class User(
                    val city_id: Int? = 0,
                    val country_code: String? = "",
                    val country_id: Int? = 0,
                    val created_at: String? = "",
                    val currency_symbol: String? = "",
                    val email: String? = "",
                    val first_name: String? = "",
                    val gender: String? = "",
                    val id: Int? = 0,
                    val language: String? = "",
                    val last_name: String? = "",
                    val latitude: Any? = Any(),
                    val login_by: String? = "",
                    val longitude: Any? = Any(),
                    val mobile: String? = "",
                    val payment_mode: String? = "",
                    val picture: String? = "",
                    val rating: String? = "",
                    val state_id: Int? = 0,
                    val status: Int? = 0,
                    val user_type: String? = "",
                    val wallet_balance: Double? = 0.0
            )

            data class Provider(
                    val activation_status: Int? = 0,
                    val admin_id: Any? = Any(),
                    val city_id: Int? = 0,
                    val country_code: String? = "",
                    val country_id: Int? = 0,
                    val currency: Any? = Any(),
                    val currency_symbol: String? = "",
                    val device_id: Any? = Any(),
                    val device_token: Any? = Any(),
                    val device_type: Any? = Any(),
                    val email: String? = "",
                    val first_name: String? = "",
                    val gender: String? = "",
                    val id: Int? = 0,
                    val is_assigned: Int? = 0,
                    val is_bankdetail: Int? = 0,
                    val is_document: Int? = 0,
                    val is_online: Int? = 0,
                    val is_service: Int? = 0,
                    val language: String? = "",
                    val last_name: String? = "",
                    val latitude: Double? = 0.0,
                    val login_by: String? = "",
                    val longitude: Double? = 0.0,
                    val mobile: String? = "",
                    val otp: Any? = Any(),
                    val payment_gateway_id: Any? = Any(),
                    val payment_mode: String? = "",
                    val picture: Any? = Any(),
                    val qrcode_url: String? = "",
                    val rating: Double? = 0.0,
                    val referal_count: Int? = 0,
                    val referral_unique_id: String? = "",
                    val social_unique_id: Any? = Any(),
                    val state_id: Int? = 0,
                    val status: String? = "",
                    val stripe_cust_id: Any? = Any(),
                    val wallet_balance: Double? = 0.0,
                    val zone_id: Any? = Any()
            )

            data class Chat(
                    val data: List<ChatData?>? = listOf(),
                    val admin_service_id: Int? = 0,
                    val company_id: Int? = 0,
                    val id: Int? = 0,
                    val request_id: Int? = 0
            ) {
                data class ChatData(
                        val message: String? = "",
                        val provider: String? = "",
                        val type: String? = "",
                        val user: String? = ""
                )
            }

            data class Payment(
                    val card: Double? = 0.0,
                    val cash: Double? = 0.0,
                    val commision: Double? = 0.0,
                    val commision_percent: Double? = 0.0,
                    val company_id: Int? = 0,
                    val discount: Double? = 0.0,
                    val discount_percent: Int? = 0,
                    val distance: Double? = 0.0,
                    val fixed: Double? = 0.0,
                    val fleet: Double? = 0.0,
                    val fleet_id: Any? = Any(),
                    val fleet_percent: Int? = 0,
                    val hour: Double? = 0.0,
                    val id: Int? = 0,
                    val is_partial: Any? = Any(),
                    val minute: Double? = 0.0,
                    val payable: Double? = 0.0,
                    val payment_id: Any? = Any(),
                    val payment_mode: String? = "",
                    val peak_amount: Double? = 0.0,
                    val peak_comm_amount: Double? = 0.0,
                    val promocode_id: Any? = Any(),
                    val provider_id: Int? = 0,
                    val provider_pay: Double? = 0.0,
                    val ride_request_id: Int? = 0,
                    val round_of: Double? = 0.0,
                    val tax: Double? = 0.0,
                    val tax_percent: Double? = 0.0,
                    val tips: Double? = 0.0,
                    val toll_charge: Double? = 0.0,
                    val total: Double? = 0.0,
                    val total_waiting_time: Int? = 0,
                    val user_id: Int? = 0,
                    val waiting_amount: Double? = 0.0,
                    val waiting_comm_amount: Double? = 0.0,
                    val wallet: Double? = 0.0
            )
        }
    }
}