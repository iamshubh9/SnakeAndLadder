package model;

public class SnakeLadder {
     int start;
     int end;

     String type;

     public SnakeLadder(int start , int end) {
          this.start = start;
          this.end = end;
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public Player jump(Player currentPlayer/*, SnakeLadder jump*/) {
          int end = this.end;
          currentPlayer.setCurrentPosition(end);
          return currentPlayer;
     }

}
