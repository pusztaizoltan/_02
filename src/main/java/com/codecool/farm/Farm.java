package com.codecool.farm;

import com.codecool.farm.animal.Animal;

import java.util.List;
import java.util.stream.Collectors;

class Farm {
	private List<Animal> animals;

	public Farm(List<Animal> animals) {
		this.animals = animals;
	}

	public void feedAnimals() {
		animals.forEach(Animal::feed);
	}

	public void butcher(Butcher butcher) {
		animals.removeIf(butcher::canButcher);
	}

	public boolean isEmpty() {
		return animals.isEmpty();
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public List<String> getStatus(){
		return animals.stream().map(
			animal -> String.format("There is a %s sized %s in the farm.",
									animal.getSize(),
									getAnimalName(animal))
			).collect(Collectors.toList());
	}

	public String getAnimalName(Animal animal){
		return animal.getClass().getSimpleName().toLowerCase();
	}
}

