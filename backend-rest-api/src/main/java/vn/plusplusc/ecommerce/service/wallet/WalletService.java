package vn.plusplusc.ecommerce.service.wallet;

import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.Wallet;

public interface WalletService {
	Wallet findByUserId(String id);
	void updateWallet(Wallet wallet);
}
