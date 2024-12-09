package umc.hospital.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.hospital.apiPayload.ApiResponse;
import umc.hospital.apiPayload.code.status.ErrorStatus;
import umc.hospital.apiPayload.exception.GeneralException;
import umc.hospital.converter.ReservationConverter;
import umc.hospital.domain.Reservation;
import umc.hospital.repository.ReservationRepository;
import umc.hospital.service.ReservationService.ReservationCommandService;
import umc.hospital.service.ReservationService.ReservationQueryService;
import umc.hospital.web.dto.ReservationRequestDTO;
import umc.hospital.web.dto.ReservationResponseDTO;

import java.util.List;

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

    @PostMapping("/myReservations")
    public ApiResponse<List<ReservationResponseDTO.ReservationResultDTO>>
            selectReservation(@RequestBody @Valid ReservationRequestDTO.selectReservationDTO request){

        List<ReservationResponseDTO.ReservationResultDTO> resultList = reservationCommandService.selectReservationList(request);
        return ApiResponse.onSuccess(resultList);
    }

    @PostMapping("/{reservationId}")
    public ApiResponse<ReservationResponseDTO.ReservationResultDTO>
            cancelReservation(@PathVariable @Valid Long reservationId){

        Reservation reservation = reservationCommandService.changeStatus(reservationId);
        return ApiResponse.onSuccess(ReservationConverter.toReservationResult(reservation));
    }
}
