// Clase Mano
class Mano {
    int cantidadDedos;
    boolean tieneGuantes;

    // Constructor
    public Mano(int cantidadDedos, boolean tieneGuantes) {
        this.cantidadDedos = cantidadDedos;
        this.tieneGuantes = tieneGuantes;
    }

    // Método
    public void moverDedos() {
        System.out.println("Moviendo los " + cantidadDedos + " dedos.");
    }
}

// Clase Pierna
class Pierna {
    boolean flexionada;
    int longitud;

    // Constructor
    public Pierna(boolean flexionada, int longitud) {
        this.flexionada = flexionada;
        this.longitud = longitud;
    }

    // Método
    public void caminar() {
        System.out.println("La pierna está caminando. Longitud: " + longitud);
    }
}

// Clase Torso
class Torso {
    int capacidadEnergia;
    String material;

    // Constructor
    public Torso(int capacidadEnergia, String material) {
        this.capacidadEnergia = capacidadEnergia;
        this.material = material;
    }

    // Método
    public void almacenarEnergia() {
        System.out.println("Almacenando energía. Capacidad actual: " + capacidadEnergia);
    }
}

// Clase Cabeza
class Cabeza {
    String colorOjos;
    boolean tieneCasco;

    // Constructor
    public Cabeza(String colorOjos, boolean tieneCasco) {
        this.colorOjos = colorOjos;
        this.tieneCasco = tieneCasco;
    }

    // Método
    public void pensar() {
        System.out.println("El robot está pensando.");
    }
}

// Clase Robot
class Robot {
    Mano manoIzquierda;
    Mano manoDerecha;
    Pierna piernaIzquierda;
    Pierna piernaDerecha;
    Torso torso;
    Cabeza cabeza;

    // Constructor
    public Robot(Mano manoIzquierda, Mano manoDerecha, Pierna piernaIzquierda, Pierna piernaDerecha, Torso torso, Cabeza cabeza) {
        this.manoIzquierda = manoIzquierda;
        this.manoDerecha = manoDerecha;
        this.piernaIzquierda = piernaIzquierda;
        this.piernaDerecha = piernaDerecha;
        this.torso = torso;
        this.cabeza = cabeza;
    }

    // Método para aplicar un outfit
    public void aplicarOutfit(Outfit outfit) {
        outfit.aplicar(this);
    }
}

// Clase Outfit
abstract class Outfit {
    String color;
    String material;

    // Constructor
    public Outfit(String color, String material) {
        this.color = color;
        this.material = material;
    }

    // Método abstracto
    public abstract void aplicar(Robot robot);
}

// Clase hija de Outfit - Traje de Super Heroína (Stealth)
class StealthOutfit extends Outfit {

    public StealthOutfit(String color, String material) {
        super(color, material);
    }

    @Override
    public void aplicar(Robot robot) {
        System.out.println("Aplicando outfit de sigilo de color " + color + " y material " + material);
        // Lógica adicional para cambiar propiedades del robot si es necesario
    }
}

// Clase hija de Outfit - Traje de Super Heroína (Armadura Pesada)
class HeavyArmorOutfit extends Outfit {

    public HeavyArmorOutfit(String color, String material) {
        super(color, material);
    }

    @Override
    public void aplicar(Robot robot) {
        System.out.println("Aplicando armadura pesada de color " + color + " y material " + material);
        // Lógica adicional para cambiar propiedades del robot si es necesario
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear componentes del robot
        Mano manoIzquierda = new Mano(5, false);
        Mano manoDerecha = new Mano(5, true);
        Pierna piernaIzquierda = new Pierna(false, 100);
        Pierna piernaDerecha = new Pierna(false, 100);
        Torso torso = new Torso(1000, "Titanio");
        Cabeza cabeza = new Cabeza("Azules", true);

        // Crear robot
        Robot robot = new Robot(manoIzquierda, manoDerecha, piernaIzquierda, piernaDerecha, torso, cabeza);

        // Crear outfits
        Outfit stealthOutfit = new StealthOutfit("Negro", "Nanofibra");
        Outfit heavyArmorOutfit = new HeavyArmorOutfit("Rojo", "Acero");

        // Aplicar outfits al robot
        robot.aplicarOutfit(stealthOutfit);
        robot.aplicarOutfit(heavyArmorOutfit);
    }
}
