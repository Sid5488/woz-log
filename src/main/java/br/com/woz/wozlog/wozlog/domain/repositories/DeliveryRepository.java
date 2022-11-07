package br.com.woz.wozlog.wozlog.domain.repositories;

import br.com.woz.wozlog.wozlog.domain.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {}
