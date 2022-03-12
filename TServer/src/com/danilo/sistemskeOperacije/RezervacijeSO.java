package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.RezervacijaSobe;

public class RezervacijeSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		RezervacijaSobe rezervacijaSobe = (RezervacijaSobe) object;
		IBroker ib = new Broker();
		ib.sacuvaj(rezervacijaSobe);
		
	}

}
