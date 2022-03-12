package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.UslugeSoba;

public class UslugeSobaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		UslugeSoba uslugeSoba = (UslugeSoba) object;
		IBroker ib = new Broker();
		ib.sacuvaj(uslugeSoba);

	}

}
