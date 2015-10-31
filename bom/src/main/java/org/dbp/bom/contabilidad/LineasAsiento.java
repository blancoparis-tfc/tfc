package org.dbp.bom.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.dbp.bom.contabilidad.enums.TipoMovimientoContable;

@SuppressWarnings("serial")
@Entity
public class LineasAsiento implements Serializable{

	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name="cuenta")
	private Cuenta cuenta;
	@Enumerated(EnumType.STRING)
	private TipoMovimientoContable tipoMovimientoContable;
	
	private BigDecimal importe;
	@ManyToOne
	@JoinColumn(name="asientoId")
	private Asientos asiento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
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

	public Asientos getAsiento() {
		return asiento;
	}

	public void setAsiento(Asientos asiento) {
		this.asiento = asiento;
	}
	
	
	
	
}
