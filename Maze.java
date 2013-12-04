/**
 * clase principal del proyecto
 * @author tutoInformatica
 *
 */
public class Maze {
	final int nFilas = 4;
	final int nColumnas = 4;
	/**
	 * por defecto la variable maze es 
	 * {T,F,F,F}
	 * {T,T,T,T}
	 * {F,T,F,T}
	 * {F,F,F,T}
	 * F-> es false
	 * T-> es true
	 * 
	 */
	boolean maze[][] = {{true,false,false,false},
			 {true,true,true,true},
			 {false,true,false,true},
			 {false,false,false,true}};
	
	String posiblesMovimientos [] = {"arriba","abajo","izquierda","derecha"};
	/**
	 * guarda la posicion sobre el eje X dentro del laberinto para a la hora de 
	 * realizar los posibles movimientos no volver a hacer el anterior movimiento
	 */
	int posicionAnteriorEjeX;
	/**
	 * guarda la posicion sobre el eje Y dentro del laberinto para a la hora de 
	 * realizar los posibles movimientos no volver a hacer el anterior movimiento
	 */
	int posicionAnteriorEjeY;
	/**
	 * muestra el laberinto por pantalla es decir la 
	 * variable {@link Maze}
	 */
	public void mostrarLaberinto(){
		for(int i = 0; i < nFilas ; i++){
			for(int j = 0 ; j < nColumnas ; j++){
				System.out.print("  |");
				if(maze[i][j])System.out.print("  ");
				else System.out.print(" *");
				
			}
			System.out.println(" |");
		}
		
	}
	/**
	 * Mira si pasadas dos variables i , j cumple que estan dentro
	 * de las medidas del laberinto
	 * @param i fila
	 * @param j columna
	 * @return
	 */
	public boolean cumpleLasDimensiones(int i , int j){
		if(i < nFilas && j < nColumnas){
			if(i >= 0 && j >= 0){
				return true;
			}
		}
		return false;
		
	}
	/**
	 * mira si pasadas dos posiciones (i , j) en esa casilla hay un muro o no
	 * @param i fila actual
	 * @param j columna actual
	 * @return
	 */
	public boolean hayMuro(int i, int j){
		if(!cumpleLasDimensiones(i, j))return false;
		if(maze[i][j]){
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * esta funcion mira si el movimiento a realizar se puede hacer 
	 * es decir si no volvemos a la anterior posicion(falta implementar),
	 * si no nos pasamos de las dimensiones 
	 * si no hay muro
	 * @param movimientoActual 
	 * @param i fila
	 * @param j columna
	 * @return
	 */
	public boolean esFactibleElSiguienteMovimiento(String movimientoActual,int i , int j){
		
		if(movimientoActual.equals("arriba")){
			if(!hayMuro(i-1,j)){
					return true;	
			}
		}else if(movimientoActual.equals("abajo")){
			if(!hayMuro(i+1,j)){
				return true;
			}
		}else if(movimientoActual.equals("izquierda")){
			if(!hayMuro(i,j-1)){
				return true;
			}
		}else if(movimientoActual.equals("derecha")){
			if(!hayMuro(i,j+1)){
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]){
		Maze maze = new Maze();
		maze.mostrarLaberinto();
		maze.esFactibleElSiguienteMovimiento(maze.posiblesMovimientos[3], 0, 0);
		
	}
		
	
	
}
