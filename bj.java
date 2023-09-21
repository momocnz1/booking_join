import java.util.*;

public class bj{
    public static void main(String[] args) {
    Roomsearch roomSearch = new Roomsearch();

    Scanner p = new Scanner(System.in); 
    System.out.print("Please enter the province : ");
    String province = p.nextLine();
    
    Hotel availableroom1 = roomSearch.findAvailableRoom1(province);
    Resort availableroom2 = roomSearch.findAvailableRoom2(province);
    Apartment availableroom3 = roomSearch.findAvailableRoom3(province);
        if (availableroom1 != null ) {
            if(province.equals(availableroom1.getProvince())&& (availableroom1.getAvailablerooms() > 0)){
                System.out.println("The rooms is available in " + province); 
                System.out.println("Price : " + availableroom1.getPrice() + " , NumberOfRooms : " + availableroom1.getNumberOfHotel()+ " , Available rooms : " + availableroom1.getAvailablerooms());
            }
            else if (availableroom1.getAvailablerooms() == 0){
            System.out.println("The rooms in the " + province +" are fully booked");
            }
        }
        else {
            System.out.println("There are no hotels in " + province);
        }
        if(availableroom2 != null){
            if (province.equals(availableroom2.getProvince())&& (availableroom2.getAvailablerooms() > 0)) {
                System.out.println("The resort is available in " + province); 
                System.out.println("Price : " + availableroom2.getPrice() + " , NumberOfRooms : " + availableroom2.getNumberOfHotel()+ " , Available rooms : " + availableroom2.getAvailablerooms());
            }else if(availableroom2.getAvailablerooms() == 0){
            System.out.println("The resort in the " + province +" are fully booked");
            }
        }
        else {
            System.out.println("There are no resorts in " + province);
        }
        if(availableroom3 != null){
            if (province.equals(availableroom3.getProvince()) && (availableroom3.getAvailablerooms() > 0)) {
                System.out.println("The resort is available in " + province); 
                System.out.println("Price : " + availableroom3.getPrice() + " , NumberOfRooms : " + availableroom3.getNumberOfHotel()+ " , Available rooms : " + availableroom3.getAvailablerooms());
            }else if(availableroom3.getAvailablerooms() == 0 ){
                System.out.println("The apartments in the " + province +" are fully booked");
            }
        }
        else {
            System.out.println("There are no apartments in " + province);
        }

        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the name of the guest : ");
        String guestName = s.nextLine();
        System.out.print("You entered room number : ");
        int roomNum = s.nextInt();
        Room room = new Room(roomNum);
        Reservation reservation = new Reservation(room, guestName);
        s.close();

        int reservationId = reservation.getReservationId();
        System.out.println("Reservation ID: " + reservationId);
        Room reservedRoom = reservation.getRoom();
        int roomNumber = reservedRoom.getRoomNum();
        System.out.println("Reserved Room Number: " + roomNumber);
        String guestname = reservation.getGuestName();
        System.out.println("Guest Name: " + guestname);
        boolean isReserved = reservedRoom.isReserved();
        System.out.println("Is Room Reserved: " + isReserved);

        Reservation reservation1 = new Reservation(room, "John Doe");
        reservation1.cancelReservation();

    
    }
}
class Roomsearch{
    private List<Hotel> rooms;
    Roomsearch(){
        rooms = new ArrayList<>();
        resorts = new ArrayList<>();
        apartments = new ArrayList<>();
        rooms.add(new Hotel("Bangkok", 2000, 360, 0));
        rooms.add(new Hotel("Samut Prakan", 1000, 20, 14));
        rooms.add(new Hotel("Nonthaburi", 3500, 50, 0));
        rooms.add(new Hotel("Pathum Thani", 4500, 120, 0));
        rooms.add(new Hotel("Samut Sakhon", 1200, 130, 20));
        rooms.add(new Hotel("Nakhon Pathom", 1400, 90, 40));
        rooms.add(new Hotel("Phra Nakhon Si Ayutthayn", 4500, 60, 0));
        rooms.add(new Hotel("Ang Thong", 1300, 90, 0));
        rooms.add(new Hotel("Lopburi", 1000, 100, 10));
        rooms.add(new Hotel("Sing Buri", 1410, 140, 1));
        rooms.add(new Hotel("Chai Nat", 1440, 430, 40));
        rooms.add(new Hotel("Saraburi", 1340, 140, 10));
        rooms.add(new Hotel("Saraburi", 4140, 140, 40));
        rooms.add(new Hotel("Rayong", 1340, 340, 30));
        rooms.add(new Hotel("Chanthaburi", 1340, 430, 340));
        rooms.add(new Hotel("Trat", 4310, 450, 340));
        rooms.add(new Hotel("Chachoengsao", 1340, 330, 30));
        rooms.add(new Hotel("Prachinburi", 4330, 230, 30));
        rooms.add(new Hotel("Nakhon Nayok", 1230, 420, 0));
        rooms.add(new Hotel("Sa Kaeo", 2520, 240, 0));
        rooms.add(new Hotel("Nakhon Ratchasima", 1430, 220, 0));
        rooms.add(new Hotel("Buri Ram", 4340, 330, 0));
        rooms.add(new Hotel("Surin", 2410, 230, 20));
        rooms.add(new Hotel("Si Sa Ket", 1340, 340, 30));
        rooms.add(new Hotel("Ubon Ratchathani", 1340, 310, 0));
        rooms.add(new Hotel("Yasothon", 1430, 320, 0));
        rooms.add(new Hotel("Chaiyaphum", 1410, 340, 10));
        rooms.add(new Hotel("Amnat Charoen", 4340, 430, 40));
        rooms.add(new Hotel("Bueng Kan", 1430, 430, 20));
        rooms.add(new Hotel("Nong Bua Lam Phu", 1430, 230, 50));
        rooms.add(new Hotel("Khon Kaen", 2410, 230, 230));
        rooms.add(new Hotel("Udon Thani", 1340, 250, 20));
        rooms.add(new Hotel("Loei", 5220, 202, 20));
        rooms.add(new Hotel("Nong Khai", 2440, 330, 0));
        rooms.add(new Hotel("Maha Sarakham", 1230, 230, 0));
        rooms.add(new Hotel("Roi Et", 5420, 540, 60));
        rooms.add(new Hotel("Kalasin", 2430, 120, 20));
        rooms.add(new Hotel("Sakon Nakhon", 1440, 430, 20));
        rooms.add(new Hotel("Nakhon Phanom", 2410, 330, 20));
        rooms.add(new Hotel("Mukdahan", 4320, 340, 40));
        rooms.add(new Hotel("Chiang Mai", 1230, 230, 20));
        rooms.add(new Hotel("Lamphun", 3410, 420, 20));
        rooms.add(new Hotel("Lampang", 1430, 210, 10));
        rooms.add(new Hotel("Uttharadit", 3220, 110, 10));
        rooms.add(new Hotel("Phrae", 3450, 240, 10));
        rooms.add(new Hotel("Nan", 1230, 140, 10));
        rooms.add(new Hotel("Phayao", 1200, 100, 3));
        rooms.add(new Hotel("Chiang Rai", 3560, 440, 4));
        rooms.add(new Hotel("Mae Hong Son", 2560, 230, 0));
        rooms.add(new Hotel("Nakhon Sawan", 2350, 210, 0));
        rooms.add(new Hotel("Uthai Thani", 1560, 420, 10));
        rooms.add(new Hotel("Kamphaeng Phet", 1560, 230, 40));
        rooms.add(new Hotel("Tak", 1530, 440, 240));
        rooms.add(new Hotel("Sukhothai", 1320, 440, 0));
        rooms.add(new Hotel("Phitsanulok", 1330, 320, 30));
        rooms.add(new Hotel("Phetchabun", 1230, 220, 20));
        rooms.add(new Hotel("Ratchaburi", 1230, 230, 20));
        rooms.add(new Hotel("Kanchanaburi", 1230, 340, 0));
        rooms.add(new Hotel("Suphan Buri", 3550, 240, 30));
        rooms.add(new Hotel("Nakhon Pathom", 3450, 220, 30));
        rooms.add(new Hotel("Samut Sakhon", 1340, 440, 30));
        rooms.add(new Hotel("Samut Songkhram", 1350, 240, 40));
        rooms.add(new Hotel("Phetchaburi", 3450, 340, 50));
        rooms.add(new Hotel("Prachuap Khiri Khan", 4560, 230, 50));
        rooms.add(new Hotel("Chumphon", 1230, 240, 60));
        rooms.add(new Hotel("Ranong", 3650, 440, 230));
        rooms.add(new Hotel("Surat Thani", 4060, 430, 30));
        rooms.add(new Hotel("Phang Nga", 6700, 440, 20));
        rooms.add(new Hotel("Phuket", 6700, 450, 40));
        rooms.add(new Hotel("Krabi", 6500, 450, 230));
        rooms.add(new Hotel("Nakhon Si Thammarat", 4500, 430, 340));
        rooms.add(new Hotel("Trang", 5600, 330, 40));
        rooms.add(new Hotel("Phatthalung", 1240, 330, 20));
        rooms.add(new Hotel("Satun", 1440, 330, 30));
        rooms.add(new Hotel("Songkhla", 1440, 420, 30));
        rooms.add(new Hotel("Pattani", 1700, 440, 240));
        rooms.add(new Hotel("Yala", 1700, 440, 440));
        rooms.add(new Hotel("Narathiwat", 2300, 240, 40));
        
        resorts.add(new Resort("Bangkok", 4580, 90, 20, 120, 70));
        resorts.add(new Resort("Samut Prakan", 1000, 20, 7, 10, 10));
        resorts.add(new Resort("Nonthaburi", 3500, 50, 0, 30, 20));
        resorts.add(new Resort("Pathum Thani", 4500, 120, 0, 43, 40));
        resorts.add(new Resort("Samut Sakhon", 1200, 130, 10, 10, 20));
        resorts.add(new Resort("Nakhon Pathom", 1400, 90, 10, 32, 32));
        resorts.add(new Resort("Phra Nakhon Si Ayutthayn", 4500, 60, 0, 20, 10));
        resorts.add(new Resort("Ang Thong", 1300, 90, 0, 20, 10));
        resorts.add(new Resort("Lopburi", 1000, 100, 10, 34, 12));
        resorts.add(new Resort("Sing Buri", 1410, 140, 1, 10, 20));
        resorts.add(new Resort("Chai Nat", 1440, 430, 20, 20, 10));
        resorts.add(new Resort("Saraburi", 1340, 140, 10, 10, 12));
        resorts.add(new Resort("Saraburi", 4140, 140, 20, 20, 20));
        resorts.add(new Resort("Rayong", 1340, 340, 30, 30, 30));
        resorts.add(new Resort("Chanthaburi", 1340, 430, 20, 20, 10));
        resorts.add(new Resort("Trat", 4310, 450, 20, 20, 20));
        resorts.add(new Resort("Chachoengsao", 1340, 330, 30, 10, 10));
        resorts.add(new Resort("Prachinburi", 4330, 230, 30, 5, 4));
        resorts.add(new Resort("Nakhon Nayok", 1230, 420, 0, 10, 10));
        resorts.add(new Resort("Sa Kaeo", 2520, 240, 0, 20, 10));
        resorts.add(new Resort("Nakhon Ratchasima", 1430, 220, 0, 20, 10));
        resorts.add(new Resort("Buri Ram", 4340, 330, 3, 20, 30));
        resorts.add(new Resort("Surin", 2410, 230, 2, 3, 2));
        resorts.add(new Resort("Si Sa Ket", 1340, 340, 0, 20, 20));
        resorts.add(new Resort("Ubon Ratchathani", 1340, 310, 0, 0, 0));
        resorts.add(new Resort("Yasothon", 1430, 320, 0, 0, 0));
        resorts.add(new Resort("Chaiyaphum", 1410, 340, 0, 20, 30));
        resorts.add(new Resort("Amnat Charoen", 4340, 430, 20, 20, 10));
        resorts.add(new Resort("Bueng Kan", 1430, 430, 20, 20, 10));
        resorts.add(new Resort("Nong Bua Lam Phu", 1430, 230, 10, 10, 10));
        resorts.add(new Resort("Khon Kaen", 2410, 230, 10, 10, 20));
        resorts.add(new Resort("Udon Thani", 1340, 250, 20, 30, 20));
        resorts.add(new Resort("Loei", 5220, 202, 20, 10, 20));
        resorts.add(new Resort("Nong Khai", 2440, 330, 0, 10, 10));
        resorts.add(new Resort("Maha Sarakham", 1230, 230, 10, 10, 20));
        resorts.add(new Resort("Roi Et", 5420, 540, 20, 20, 10));
        resorts.add(new Resort("Kalasin", 2430, 120, 20, 20, 20));
        resorts.add(new Resort("Sakon Nakhon", 1440, 430, 0, 20, 20));
        resorts.add(new Resort("Nakhon Phanom", 2410, 330, 20, 20, 20));
        resorts.add(new Resort("Mukdahan", 4320, 340, 40, 50, 50));
        resorts.add(new Resort("Chiang Mai", 1230, 230, 20, 20, 20));
        resorts.add(new Resort("Lamphun", 3410, 420, 0, 20, 10));
        resorts.add(new Resort("Lampang", 1430, 210, 10, 20, 10));
        resorts.add(new Resort("Uttharadit", 3220, 110, 10,12,23));
        resorts.add(new Resort("Phrae", 3450, 240, 0,12,12));
        resorts.add(new Resort("Nan", 1230, 140, 0,12,1));
        resorts.add(new Resort("Phayao", 1200, 100, 0,12,22));
        resorts.add(new Resort("Chiang Rai", 3560, 440, 4,12,21));
        resorts.add(new Resort("Mae Hong Son", 2560, 230, 0,1,2));
        resorts.add(new Resort("Nakhon Sawan", 2350, 210, 0,12,21));
        resorts.add(new Resort("Uthai Thani", 1560, 420, 10,23,32));
        resorts.add(new Resort("Kamphaeng Phet", 1560, 230, 0,12,21));
        resorts.add(new Resort("Tak", 1530, 440, 20,12,21));
        resorts.add(new Resort("Sukhothai", 1320, 440, 0, 10, 10));
        resorts.add(new Resort("Phitsanulok", 1330, 320, 0, 20, 12));
        resorts.add(new Resort("Phetchabun", 1230, 220, 0, 10, 10));
        resorts.add(new Resort("Ratchaburi", 1230, 230, 0,12,12));
        resorts.add(new Resort("Kanchanaburi", 3000, 20, 5, 2, 3));
        resorts.add(new Resort("Suphan Buri", 3550, 240, 3,12,12));
        resorts.add(new Resort("Nakhon Pathom", 3450, 220, 0,12,12));
        resorts.add(new Resort("Samut Sakhon", 1340, 440, 3,12,12));
        resorts.add(new Resort("Samut Songkhram", 1350, 240, 0,21,21));
        resorts.add(new Resort("Phetchaburi", 3450, 340, 5,12,23));
        resorts.add(new Resort("Prachuap Khiri Khan", 4560, 230, 5,12,23));
        resorts.add(new Resort("Chumphon", 1230, 240, 0,12,12));
        resorts.add(new Resort("Ranong", 3650, 440, 20,21,12));
        resorts.add(new Resort("Surat Thani", 4060, 430, 0,12,23));
        resorts.add(new Resort("Phang Nga", 6200, 440, 2,12,32));
        resorts.add(new Resort("Phuket", 6200, 450, 4,12,23));
        resorts.add(new Resort("Krabi", 6530, 450, 2,23,43));
        resorts.add(new Resort("Nakhon Si Thammarat", 4500, 430, 40,12,2));
        resorts.add(new Resort("Trang", 5200, 330, 4,13,3));
        resorts.add(new Resort("Phatthalung", 1340, 330, 2,12,2));
        resorts.add(new Resort("Satun", 1430, 330, 23,23,23));
        resorts.add(new Resort("Songkhla", 1340, 420, 3,23,23));
        resorts.add(new Resort("Pattani", 1200, 440, 2,23,12));
        resorts.add(new Resort("Yala", 1700, 440, 4,12,2));
        resorts.add(new Resort("Narathiwat", 2300, 240, 4,12,12));
        
        apartments.add(new Apartment("Bangkok", 3900, 100, 30, 0, false));
        apartments.add(new Apartment("Samut Prakan", 1000, 20, 14, 0, false));
        apartments.add(new Apartment("Nonthaburi", 3500, 50, 0, 0, false));
        apartments.add(new Apartment("Pathum Thani", 4500, 120, 0, 0, false));
        apartments.add(new Apartment("Samut Sakhon", 1200, 130, 20, 0, false));
        apartments.add(new Apartment("Nakhon Pathom", 1400, 90, 40,12,false));
        apartments.add(new Apartment("Phra Nakhon Si Ayutthayn", 4500, 60, 0,12,true));
        apartments.add(new Apartment("Ang Thong", 1300, 90, 4,5,true));
        apartments.add(new Apartment("Lopburi", 1000, 100, 10,23,true));
        apartments.add(new Apartment("Sing Buri", 1410, 140, 1,12,false));
        apartments.add(new Apartment("Chai Nat", 1440, 430, 40,23,true));
        apartments.add(new Apartment("Saraburi", 1340, 140, 10,23,true));
        apartments.add(new Apartment("Saraburi", 4140, 140, 40,23,false));
        apartments.add(new Apartment("Rayong", 1340, 340, 30,23,true));
        apartments.add(new Apartment("Chanthaburi", 1340, 430, 0,23,true));
        apartments.add(new Apartment("Trat", 4310, 450, 0,12,true));
        apartments.add(new Apartment("Chachoengsao", 1340, 330, 0,12,true));
        apartments.add(new Apartment("Prachinburi", 4330, 230, 30,23,false));
        apartments.add(new Apartment("Nakhon Nayok", 1230, 420, 10,12,true));
        apartments.add(new Apartment("Sa Kaeo", 2520, 240, 0,2,true));
        apartments.add(new Apartment("Nakhon Ratchasima", 1430, 220, 10,12,true));
        apartments.add(new Apartment("Buri Ram", 4340, 330, 0,12,false));
        apartments.add(new Apartment("Surin", 2410, 230, 20,12,false));
        apartments.add(new Apartment("Si Sa Ket", 1340, 340, 30,40,false));
        apartments.add(new Apartment("Ubon Ratchathani", 1340, 310, 0,12,false));
        apartments.add(new Apartment("Yasothon", 1430, 320, 10,12,true));
        apartments.add(new Apartment("Chaiyaphum", 1410, 340, 1,12,false));
        apartments.add(new Apartment("Amnat Charoen", 4340, 430, 10,23,false));
        apartments.add(new Apartment("Bueng Kan", 1430, 430, 2,24,true));
        apartments.add(new Apartment("Nong Bua Lam Phu", 1430, 230, 0,12,true));
        apartments.add(new Apartment("Khon Kaen", 2410, 230, 0,12,true));
        apartments.add(new Apartment("Udon Thani", 1340, 250, 0,21,false));
        apartments.add(new Apartment("Loei", 5220, 202, 0,12,false));
        apartments.add(new Apartment("Nong Khai", 2440, 330, 0,12,true));
        apartments.add(new Apartment("Maha Sarakham", 1230, 230, 0,13,true));
        apartments.add(new Apartment("Roi Et", 5420, 540, 0,12,true));
        apartments.add(new Apartment("Kalasin", 2430, 120, 0,3,false));
        apartments.add(new Apartment("Sakon Nakhon", 1440, 430, 0,12,true));
        apartments.add(new Apartment("Nakhon Phanom", 2410, 330, 0,12,false));
        apartments.add(new Apartment("Mukdahan", 4320, 340, 0,21,false));
        apartments.add(new Apartment("Chiang Mai", 1230, 230, 0,12,true));
        apartments.add(new Apartment("Lamphun", 3410, 420,0,24,false));
        apartments.add(new Apartment("Lampang", 1430, 210, 0,12,false));
        apartments.add(new Apartment("Uttharadit", 3220, 110, 0,12,false));
        apartments.add(new Apartment("Phrae", 3450, 240, 0,12,true));
        apartments.add(new Apartment("Nan", 1200, 20, 0, 20, false));
        apartments.add(new Apartment("Phayao", 1200, 100, 3,12,false));
        apartments.add(new Apartment("Chiang Rai", 3560, 440, 12,12,true));
        apartments.add(new Apartment("Mae Hong Son", 2560, 230, 0,2,true));
        apartments.add(new Apartment("Nakhon Sawan", 2350, 210, 0,12,true));
        apartments.add(new Apartment("Uthai Thani", 1560, 420, 10,12,true));
        apartments.add(new Apartment("Kamphaeng Phet", 1560, 230, 10,23,true));
        apartments.add(new Apartment("Tak", 1530, 440, 20,24,false));
        apartments.add(new Apartment("Sukhothai", 1320, 440, 0,12,false));
        apartments.add(new Apartment("Phitsanulok", 1330, 320, 0,12,false));
        apartments.add(new Apartment("Phetchabun", 1230, 220, 0,5,false));
        apartments.add(new Apartment("Ratchaburi", 1230, 230, 0,12,true));
        apartments.add(new Apartment("Kanchanaburi", 1230, 340, 0,12,false));
        apartments.add(new Apartment("Suphan Buri", 3550, 240, 0,12,true));
        apartments.add(new Apartment("Nakhon Pathom", 3450, 220, 0,12,true));
        apartments.add(new Apartment("Samut Sakhon", 1340, 440, 0,14,false));
        apartments.add(new Apartment("Samut Songkhram", 1350, 240, 0,12,true));
        apartments.add(new Apartment("Phetchaburi", 3450, 340, 10,23,true));
        apartments.add(new Apartment("Prachuap Khiri Khan", 4560, 230, 0,12,true));
        apartments.add(new Apartment("Chumphon", 1230, 240, 0,12,false));
        apartments.add(new Apartment("Ranong", 3650, 440, 10,23,true));
        apartments.add(new Apartment("Surat Thani", 4060, 430, 0,21,false));
        apartments.add(new Apartment("Phang Nga", 6700, 440, 0,1,false));
        apartments.add(new Apartment("Phuket", 6700, 450, 0,12,false));
        apartments.add(new Apartment("Krabi", 6500, 450, 30,34,true));
        apartments.add(new Apartment("Nakhon Si Thammarat", 4500, 430, 30,35,true));
        apartments.add(new Apartment("Trang", 5600, 330, 0,2,false));
        apartments.add(new Apartment("Phatthalung", 1240, 330, 0,12,false));
        apartments.add(new Apartment("Satun", 1440, 330, 0,1,false));
        apartments.add(new Apartment("Songkhla", 1440, 420, 0,12,true));
        apartments.add(new Apartment("Pattani", 1700, 440, 20,22,true));
        apartments.add(new Apartment("Yala", 1700, 440, 4,12,true));
        apartments.add(new Apartment("Narathiwat", 2300, 240, 0,12,false));
    }
    
    public Hotel findAvailableRoom1(String province){
        for(Hotel room : rooms){
            if (room.getProvince().equals(province) && room.getAvailablerooms() >= 0) {
            return room;
        }
        }
        return null;
    }
    
    private List<Resort> resorts;
    public Resort findAvailableRoom2(String province){
         for(Resort room : resorts){
            if (room.getProvince().equals(province) && room.getAvailablerooms() >= 0) {
            return room;
        }
        }
        return null;
    }
    
    private List<Apartment> apartments;
    public Apartment findAvailableRoom3(String province){
         for(Apartment room : apartments){
            if (room.getProvince().equals(province) && room.getAvailablerooms() >= 0) {
            return room;}
        }
        return null;
    }
}

class Hotel{
    private String province;
    private int price;
    private int numberOfHotel;
    private int availablerooms;
    Hotel(String province, int price, int numberOfHotel, int availableRooms){
        this.province = province;
        this.price = price;
        this.numberOfHotel = numberOfHotel;
        this.availablerooms = availableRooms;
    }
    public String getProvince(){
        return province;
    }
    public int getPrice(){
        return price;
    }
    public int getNumberOfHotel(){
        return numberOfHotel;
    }
    public int getAvailablerooms() {
        return availablerooms;
    }
}

class Resort extends Hotel{
    private int numRooms;
    private int numPools;
    Resort(String province, int price, int numberOfHotel, int availableRooms,int numRooms,int numPools){
        super(province, price, numberOfHotel, availableRooms);
        this.numRooms = numRooms;
        this.numPools = numPools;
    }
    public int getnumRooms(){
        return numRooms;
    }
    public int getnumPools(){
        return numPools;
    }
}

class Apartment extends Hotel{
    private int numUnits;
    private boolean hasParking;
    Apartment(String province, int price, int numberOfHotel, int availableRooms,int numUnits,boolean hasParking){
        super(province, price, numberOfHotel, availableRooms);
        this.numUnits = numUnits;
        this.hasParking = hasParking;
    }
    public int getnumUnits(){
        return numUnits;
    }
    public boolean gethasParking(){
        return hasParking;
    }
}

class Room{
    private int roomNum;
    private boolean isReserved;

    Room(int roomNum){
        this.roomNum = roomNum;
        this.isReserved = false;
    }
    public int getRoomNum(){
        return roomNum;
    }
    public boolean isReserved(){
        return isReserved;
    }
    public void reserveroom(){
        isReserved = true;
    }
    public void cancelReservation(){
        isReserved = false;
    }
}

class Reservation {
    private static int nextreservationId = 1;
    private int reservationId;
    private  Room room;
    private String guestName;
    
    Reservation(Room room,String guestName){
        this.reservationId = nextreservationId++;
        this.room = room;
        this.guestName = guestName;
        room.reserveroom();
    }
     public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public void cancelReservation() {
        room.cancelReservation();
    }
}