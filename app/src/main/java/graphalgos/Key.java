package graphalgos;
import java.util.Objects;

public class Key{
  private int key;
  public Key(int k) {key = k;}

  @Override
  public boolean equals(Object rhs){
    if (this == rhs) return true;
    if (rhs == null || getClass() != rhs.getClass()) return false;
    Key key2 = (Key) rhs;
    return Objects.equals(key, key2.key);
  }
}
