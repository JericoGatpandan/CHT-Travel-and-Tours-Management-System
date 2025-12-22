select * from booking;

# Booking - status, client Name
# Trip - destination and start & end date, trip id

use cht_updated;

select trip.TripID,  client.name, trip.Location, trip.startDate, trip.endDate, booking.status from trip
join booking on trip.tripID
join client on booking.clientID = client.clientID;