package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Drzava;

public class DrzavaSO extends OpstaSistemskaOperacija{

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		
		Drzava drzava = (Drzava) object;
		IBroker ib = new Broker();
		ib.sacuvaj(drzava);
	}

}
