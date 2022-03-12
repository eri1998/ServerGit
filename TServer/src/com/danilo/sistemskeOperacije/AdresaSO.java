package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Adresa;

public class AdresaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		Adresa adresa = (Adresa) object;
		IBroker ib = new Broker();
		ib.sacuvaj(adresa);
		

	}

}
