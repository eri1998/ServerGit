package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Grad;
import com.danilo.domen.OpstiDomen;

public class GradBazaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		List<OpstiDomen>listGrad = (List<OpstiDomen>) object;
		IBroker ib = new Broker();
		listGrad.addAll(ib.vratiPoslednjiPodatakBaza(new Grad()));
	}

}
