import java.util.ArrayList;
public class Pokedex extends AbstractPokemon  {
	ArrayList<Pokemon> myPokemons;
	
	public Pokedex (Pokemon pokemon) {
		myPokemons.add(pokemon);
	}
	
	public void listPokemon() {
		for(int i = 0; i<myPokemons.size(); i++) {
			System.out.println(myPokemons.get(i).name);
		}
	}

}
