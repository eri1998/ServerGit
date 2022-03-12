package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Grad;

public class GradSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		Grad grad = (Grad) object;
		IBroker ib = new Broker();
		ib.sacuvaj(grad);
		

	}

}
