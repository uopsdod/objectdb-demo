package point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cook implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private long id;

    private int x;
    private int y;
    private int z;

    public Cook() {
    }

    Cook(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Long getId() {
        return id;
    }

    public int getX() {
         return x;
    }

    public int getY() {
         return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", this.x, this.y, this.z);
    }
}