class ParkingSystem {
  public class ParkingArea {
    private int numberOfOccupied;
    private int parkingAreaSize;

    public ParkingArea(int size) {
      numberOfOccupied = 0;
      parkingAreaSize = size;
    }

    public boolean park() {
      if (numberOfOccupied < parkingAreaSize) {
        numberOfOccupied++;
        return true;
      }

      return false;
    }
  }

  private HashMap<Integer, ParkingArea> parkingAreas;

  public ParkingSystem(int big, int medium, int small) {
    parkingAreas = new HashMap<>();
    parkingAreas.put(1, new ParkingArea(big));
    parkingAreas.put(2, new ParkingArea(medium));
    parkingAreas.put(3, new ParkingArea(small));
  }

  public boolean addCar(int carType) {
    ParkingArea targetParkingArea = parkingAreas.get(carType);
    return targetParkingArea.park();
  }
}
