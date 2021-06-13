
public abstract class AbstractPokemon implements PokemonInterface {
	@Override
	public Pokemon createPokemon(String name, int health, String type){
		return new Pokemon ( name, health,  type);
	}
	public String pokemonInfo(Pokemon pokemon) {
		return pokemon.name + pokemon.type + pokemon.health;
	}
}
