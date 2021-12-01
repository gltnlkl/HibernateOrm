package com.gulukal.main;

import com.gulukal.controller.PencilController;
import com.gulukal.entity.EPencil;
import com.gulukal.entity.PencilEntity;

public class PencilMain {

	public static void main(String[] args) {
		PencilEntity entity = new PencilEntity();
		entity.setPencilName("Adel 44");
		entity.setPencilTrade("Adel");
		entity.setPencilType(EPencil.TukenmezKalem);

		PencilController pencilController = new PencilController();
		pencilController.create(entity);

	}

}