package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.OpstiDomen;
import com.danilo.domen.Soba;

public class Vrati_SVE_SOBE_SO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		List<OpstiDomen>listSoba = (List<OpstiDomen>) object;
        IBroker ib = new Broker();
        listSoba.addAll(ib.vratiFullTabeluBaza(new Soba()));
        
	}

}
