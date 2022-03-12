package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.SobaSlike;

public class SobaSlikeSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		SobaSlike sobaSlike = (SobaSlike) object;
		IBroker ib = new Broker();
		ib.sacuvaj(sobaSlike);

	}

}
