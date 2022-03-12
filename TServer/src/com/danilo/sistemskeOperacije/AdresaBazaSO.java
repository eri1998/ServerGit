package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Adresa;
import com.danilo.domen.OpstiDomen;

public class AdresaBazaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		List<OpstiDomen>listAdresa = (List<OpstiDomen>) object;
		IBroker ib = new Broker();
		listAdresa.addAll(ib.vratiPoslednjiPodatakBaza(new Adresa()));

	}

}
