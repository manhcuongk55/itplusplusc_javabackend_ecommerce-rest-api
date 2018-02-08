package vn.plusplusc.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.plusplusc.ecommerce.database.model.Wallet;;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

	Wallet findByUserId(String id);

}