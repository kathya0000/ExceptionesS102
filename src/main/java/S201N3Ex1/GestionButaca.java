package S201N3Ex1;

import java.util.ArrayList;

public class GestionButaca {
    private final ArrayList<Butaca> sillones;

    public GestionButaca() {
        sillones = new ArrayList<>();
    }

    public ArrayList<Butaca> getButacas() {

        return sillones;
    }

    /*public void anadirButaca(Butaca newbutaca) throws ExcepcioButacaOcupada {
        if (buscarButaca(newbutaca.getNumFila(), newbutaca.getNumAsiento()) != -1) {
            throw new ExcepcioButacaOcupada("La butaca ya está ocupada.");
        }
        sillones.add(newbutaca);
    }*/
    public void anadirButaca(Butaca newbutaca) throws ExcepcioButacaOcupada {
        int posicion = buscarButaca(newbutaca.getNumFila(), newbutaca.getNumAsiento());
        if (posicion != -1) {
            throw new ExcepcioButacaOcupada("La butaca ya está ocupada.");
        }
        sillones.add(newbutaca);
    }


    /* public void eliminarButaca(int nomFila, int numAsiento) throws ExcepcioButacaLliure {
        int posicion = buscarButaca(Integer.parseInt(String.valueOf(nomFila)), numAsiento);
        if (posicion == -1) {
            throw new ExcepcioButacaLliure("La butaca no está reservada.");
        }
        sillones.remove(posicion);
    }*/
   public void eliminarButaca(int nomFila, int numAsiento) throws ExcepcioButacaLliure {
       int posicion = buscarButaca(nomFila, numAsiento);
       if (posicion == -1) {
           throw new ExcepcioButacaLliure("La butaca no está reservada.");
       }
       sillones.remove(posicion);
   }



    /*private int buscarButaca(int numeFila, int numAsiento) {
        int posicion = -1;
        int i = 0;

        while (posicion == -1 && i < sillones.size()) {
            if (Integer.parseInt(String.valueOf(sillones.get(i).getNumFila())) == numeFila && sillones.get(i).getNumAsiento() == numAsiento) {
                posicion = i;
            }

            i++;
        }

        return posicion;
    }*/
    private int buscarButaca(int numFila, int numAsiento) {
        int posicion = -1;
        int i = 0;

        while (posicion == -1 && i < sillones.size()) {
            Butaca butaca = sillones.get(i);
            if (butaca.getNumFila() == numFila && butaca.getNumAsiento() == numAsiento) {
                posicion = i;
            }
            i++;
        }

        return posicion;
    }



}

