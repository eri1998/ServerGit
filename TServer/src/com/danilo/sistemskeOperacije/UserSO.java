package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.User;

public class UserSO extends OpstaSistemskaOperacija{

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		User user = (User) object;
		IBroker ib = new Broker();
		ib.sacuvaj(user);
		
	}

}
