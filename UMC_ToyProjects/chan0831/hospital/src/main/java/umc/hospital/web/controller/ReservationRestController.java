package umc.hospital.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.hospital.apiPayload.ApiResponse;
import umc.hospital.converter.ReservationConverter;
import umc.hospital.domain.Reservation;
import umc.hospital.service.ReservationService.ReservationCommandService;
import umc.hospital.service.ReservationService.ReservationCommandServiceImpl;
import umc.hospital.web.dto.ReservationRequestDTO;
import umc.hospital.web.dto.ReservationResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationRestController {

    private final ReservationCommandService reservationCommandService;

    @PostMapping
    public ApiResponse<ReservationResponseDTO.ReservationResultDTO>
            addReservation(@RequestBody @Valid ReservationRequestDTO.createReservationDTO request){

        Reservation reservation = reservationCommandService.createReservation(request);
        return ApiResponse.onSuccess(ReservationConverter.toReservationResult(reservation));
    }
}
