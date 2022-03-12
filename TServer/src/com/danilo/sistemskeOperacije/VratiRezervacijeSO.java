package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.OpstiDomen;
import com.danilo.domen.RezervacijaSobe;

public class VratiRezervacijeSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		List<OpstiDomen>listRezervacije = (List<OpstiDomen>) object;
        IBroker iBroker = new Broker();
       listRezervacije.addAll(iBroker.vratiFullTabeluBaza(new RezervacijaSobe()));
	}

}
