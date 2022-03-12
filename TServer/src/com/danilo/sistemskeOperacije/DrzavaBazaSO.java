package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Drzava;
import com.danilo.domen.OpstiDomen;

public class DrzavaBazaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		List<OpstiDomen>list = (List<OpstiDomen>) object;
		IBroker ib = new Broker();
		list.addAll(ib.vratiPoslednjiPodatakBaza(new Drzava()));
		
		

	}

}
