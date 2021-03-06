/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.data;

/**
 * [OVERVIEW] Reservation Status.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/21      LinhDT             Create new
*/
public enum ReservationStatus {

    UNDEFINED(-1), TEMP(0), RESERVED(1), BORROWING(2), CLOSED(3), CANCELED(4);

    private final Integer value;

    ReservationStatus(Integer i) {
        value = i;
    }

    public Integer value() {
        return value;
    }

    public static ReservationStatus parse(Integer i) {
        ReservationStatus state = ReservationStatus.UNDEFINED;
        for (ReservationStatus item : ReservationStatus.values()) {
            if (item.value().equals(i)) {
                state = item;
                break;
            }
        }

        return state;
    }
}
