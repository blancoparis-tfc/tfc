package org.dbp.bom.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.dbp.bom.contabilidad.enums.TipoMovimientoContable;

@Entity
public class LineasAsiento implements Serializable{

	@Id
	private Long id;
	
	private String cuenta;
	
	private TipoMovimientoContable tipoMovimientoContable;
	
	private BigDecimal importe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public TipoMovimientoContable getTipoMovimientoContable() {
		return tipoMovimientoContable;
	}

	public void setTipoMovimientoContable(
			TipoMovimientoContable tipoMovimientoContable) {
		this.tipoMovimientoContable = tipoMovimientoContable;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	
	
}
