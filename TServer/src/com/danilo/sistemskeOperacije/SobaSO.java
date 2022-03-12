package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Soba;

public class SobaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		Soba soba = (Soba) object;
		IBroker ib = new Broker();
		ib.sacuvaj(soba);
		
	}

}
