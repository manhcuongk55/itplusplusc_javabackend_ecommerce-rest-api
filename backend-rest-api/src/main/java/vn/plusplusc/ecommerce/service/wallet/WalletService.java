package vn.plusplusc.ecommerce.service.wallet;

import vn.plusplusc.ecommerce.database.model.Wallet;

public interface WalletService {
	Wallet findByUserId(String id);
}
