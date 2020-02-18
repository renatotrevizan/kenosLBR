package org.adempierelbr.sped.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.POWrapper;
import org.adempierelbr.model.MLBRNotaFiscal;
import org.adempierelbr.model.MLBRTaxAssessment;
import org.adempierelbr.model.X_LBR_TaxAssessmentLine;
import org.adempierelbr.util.BPartnerUtil;
import org.adempierelbr.util.TextUtil;
import org.adempierelbr.wrapper.I_W_AD_OrgInfo;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCity;
import org.compiere.model.MLocation;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MTable;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import efd.contribuicoes.bloco0.n1.n2.Reg0110;
import efd.contribuicoes.bloco0.n1.n2.Reg0140;
import efd.contribuicoes.blocoA.n1.n2.RegA010;
import efd.contribuicoes.blocoA.n1.n2.n3.RegA100;
import efd.contribuicoes.blocoC.n1.n2.RegC010;
import efd.contribuicoes.blocoD.n1.n2.RegD010;
import efd.contribuicoes.blocoM.n1.n2.RegM100;
import efd.contribuicoes.blocoM.n1.n2.RegM200;
import efd.contribuicoes.blocoM.n1.n2.RegM400;
import efd.contribuicoes.blocoM.n1.n2.RegM500;
import efd.contribuicoes.blocoM.n1.n2.RegM600;
import efd.contribuicoes.blocoM.n1.n2.RegM800;
import efd.contribuicoes.blocoM.n1.n2.n3.RegM205;
import efd.contribuicoes.blocoM.n1.n2.n3.RegM210;
import efd.contribuicoes.blocoM.n1.n2.n3.RegM410;
import efd.contribuicoes.blocoM.n1.n2.n3.RegM605;
import efd.contribuicoes.blocoM.n1.n2.n3.RegM610;
import efd.contribuicoes.blocoM.n1.n2.n3.RegM810;
import efd.contribuicoes.blocoM.n1.n2.n3.n4.RegM211;
import efd.contribuicoes.blocoM.n1.n2.n3.n4.RegM611;
import efd.icmsipi.bloco0.Reg0000;

public class SPEDUtil 
{

	
	
	
	
	
	
	
	
	
	/** String PIPE			*/
	public static final String PIPE 				= "|";
	
	/**	String EOL 			*/
	public static final String EOL  				= TextUtil.EOL_WIN32;
	
	/**	SPED ECD			*/
	public static final int TYPE_ECD 				= 0;
	
	/**	SPED EFD			*/
	public static final int TYPE_EFD 				= 1;
	
	/** SPED Contribuições	*/
	public static final int TYPE_CONTRIB 			= 2;
	
	/** Versão da ECD		*/
	public static final String ECD_VERSION 			= "";
	
	/**	Versão da EFD		*/
	public static final String EFD_VERSION 			= "";
	
	/**	Versão da EFD Contribuições */
	public static final String CONTRIB_VERSION 		= "003";
	
	public static final String IND_OPER_CONTRATADO 	= "0";
	public static final String IND_OPER_PRESTADO 	= "1";
	
	public static final String IND_EMIT_PROPRIA 	= "0";
	public static final String IND_EMIT_TERCEIROS 	= "1";

	public static final String COD_SIT_REGULAR 		= "00";
	public static final String COD_SIT_CANCELADO 	= "02";
	
	public static final String IND_PAGTO_VISTA	 	= "0";
	public static final String IND_PAGTO_PRAZO	 	= "1";
	public static final String IND_PAGTO_SEM	 	= "9";
	
	/**
	 * 	Indicador de movimento
	 * 		<li>0 - Bloco com dados informados;
	 */
	public static final String IND_MOV_COM_DADOS 	= "0";
	
	/**
	 * 	Indicador de movimento
	 * 		<li>1 - Bloco sem dados informados
	 */
	public static final String IND_MOV_SEM_DADOS 	= "1";
	
	/** Frete: Emitente						*/
	public static final String IND_FRT_EMIT		 	= "0";
	
	/**	Frete: Destinatário ou Remetente	*/
	public static final String IND_FRT_DEST_REMT 	= "1";
	
	/**	Frete: Terceiros					*/
	public static final String IND_FRT_TERC		 	= "2";
	
	/**	Frete: Sem Cobrança					*/
	public static final String IND_FRT_SEM		 	= "9";
	
	/** Indicador de período de apuração do IPI Mensal 		*/
	public static final String IND_APUR_MENSAL	 	= "0";
	
	/** Indicador de período de apuração do IPI Decendial	*/
	public static final String IND_APUR_DECENDIAL 	= "1";
	
	/** 1 – Escrituração de operações com incidência exclusivamente no regime não-cumulativo */
	public static final String COD_INC_TRIB_NAO_CUM = "1";
	
	/** 2 – Escrituração de operações com incidência exclusivamente no regime cumulativo */
	public static final String COD_INC_TRIB_CUM = "2";
	
	/** 3 – Escrituração de operações com incidência nos regimes não-cumulativo e cumulativo */
	public static final String COD_INC_TRIB_AMBOS = "3";
	
	/** 1 – Método de Apropriação Direta */
	public static final String IND_APRO_CRED_DIRETA 			= "1";
	
	/** 2 – Método de Rateio Proporcional (Receita Bruta) */
	public static final String IND_APRO_CRED_PROPORCIONAL 		= "2";

	/** 1 – Apuração da Contribuição Exclusivamente a Alíquota Básica */
	public static final String COD_TIPO_CONT_ALIQ_BASICA 		= "1";
	
	/** 2 – Apuração da Contribuição a Alíquotas Específicas (Diferenciadas e/ou 
	 * 			por Unidade de Medida de Produto)  */
	public static final String COD_TIPO_CONT_ALIQ_ESPECIFICA 	= "2";
	
	/** 1 – Regime de Caixa – Escrituração consolidada (Registro F500) */
	public static final String IND_REG_CUM_CAIXA 				= "1";
	
	/** 2 – Regime de Competência - Escrituração consolidada (Registro F550) */
	public static final String IND_REG_CUM_COMPT 				= "2";
	
	/** 9 – Regime de Competência - Escrituração detalhada, com base nos registros dos Blocos “A”, “C”, “D” e “F” */
	public static final String IND_REG_CUM_COMPT_DET 			= "9";
	
	/** Nota Fiscal - 01 */
	public static final String COD_MOD_NF 									= "01";

	/** Nota Fiscal Avulsa - 1B */
	public static final String COD_MOD_NF_AVULSA 							= "1B";

	/** Nota Fiscal de Venda a Consumidor - 02 */
	public static final String COD_MOD_NF_DE_VENDA_A_CONSUMIDOR 			= "02";

	/** Cupom Fiscal emitido por ECF - 2D */
	public static final String COD_MOD_CUPOM_FISCAL_EMITIDO_POR_ECF 		= "2D";

	/** Bilhete de Passagem emitido por ECF - 2E */
	public static final String COD_MOD_BILHETE_DE_PASSAGEM_EMITIDO_POR_ECF 	= "2E";

	/** Nota Fiscal de Produtor - 04 */
	public static final String COD_MOD_NF_DE_PRODUTOR 						= "04";

	/** Nota Fiscal/Conta de Energia Elétrica - 06 */
	public static final String COD_MOD_NF_CONTA_DE_ENERGIA_ELETRICA 		= "06";

	/** Nota Fiscal de Serviço de Transporte - 07 */
	public static final String COD_MOD_NF_DE_SERV_DE_TRANSP 				= "07";

	/** Conhecimento de Transporte Rodoviário de Cargas - 08 */
	public static final String COD_MOD_CT_RODOVIARIO_DE_CARGAS 				= "08";

	/** Conhecimento de Transporte de Cargas Avulso - 8B */
	public static final String COD_MOD_CT_DE_CARGAS_AVULSO 					= "8B";

	/** Conhecimento de Transporte Aquaviário de Cargas - 09 */
	public static final String COD_MOD_CT_AQUAVIARIO_DE_CARGAS 				= "09";

	/** Conhecimento Aéreo - 10 */
	public static final String COD_MOD_CONHECIMENTO_AEREO 					= "10";

	/** Conhecimento de Transporte Ferroviário de Cargas - 11 */
	public static final String COD_MOD_CT_FERROVIARIO_DE_CARGAS 			= "11";

	/** Bilhete de Passagem Rodoviário - 13 */
	public static final String COD_MOD_BILHETE_DE_PASSAGEM_RODOVIARIO 		= "13";

	/** Bilhete de Passagem Aquaviário - 14 */
	public static final String COD_MOD_BILHETE_DE_PASSAGEM_AQUAVIARIO 		= "14";

	/** Bilhete de Passagem e Nota de Bagagem - 15 */
	public static final String COD_MOD_BILHETE_DE_PASSAGEM_E_NOTA_DE_BAGAGEM  = "15";

	/** Despacho de Transporte - 17 */
	public static final String COD_MOD_DESPACHO_DE_TRANSP 					= "17";

	/** Bilhete de Passagem Ferroviário - 16 */
	public static final String COD_MOD_BILHETE_DE_PASSAGEM_FERROVIARIO 		= "16";

	/** Resumo de Movimento Diário - 18 */
	public static final String COD_MOD_RESUMO_DE_MOVIMENTO_DIARIO 			= "18";

	/** Ordem de Coleta de Cargas - 20 */
	public static final String COD_MOD_ORDEM_DE_COLETA_DE_CARGAS 			= "20";

	/** Nota Fiscal de Serviço de Comunicação - 21 */
	public static final String COD_MOD_NF_DE_SERV_DE_COMUNICACAO 			= "21";

	/** Nota Fiscal de Serviço de Telecomunicação - 22 */
	public static final String COD_MOD_NF_DE_SERV_DE_TELECOMUNICACAO 		= "22";

	/** GNRE - 23 */
	public static final String COD_MOD_GNRE 								= "23";

	/** Autorização de Carregamento e Transporte - 24 */
	public static final String COD_MOD_AUT_DE_CARREGAMENTO_E_TRANSP 		= "24";

	/** Manifesto de Carga - 25 */
	public static final String COD_MOD_MANIFESTO_DE_CARGA 					= "25";

	/** Conhecimento de Transporte Multimodal de Cargas - 26 */
	public static final String COD_MOD_CT_MULTIMODAL_DE_CARGAS 				= "26";

	/** Nota Fiscal de Transporte Ferroviário de Cargas - 27 */
	public static final String COD_MOD_NF_DE_TRANSP_FERROVIARIO_DE_CARGAS 	= "27";

	/** Nota Fiscal/Conta de Fornecimento de Gás Canalizado - 28 */
	public static final String COD_MOD_NF_CONTA_DE_FORN_DE_GAS_CANALIZADO 	= "28";

	/** Nota Fiscal/Conta de Fornecimento de Água Canalizada - 29 */
	public static final String COD_MOD_NF_CONTA_DE_FORN_DE_AGUA_CANALIZADA 	= "29";

	/** Bilhete/Recibo do Passageiro - 30 */
	public static final String COD_MOD_BILHETE_RECIBO_DO_PASSAGEIRO 		= "30";

	/** Nota Fiscal Eletrônica - 55 */
	public static final String COD_MOD_NF_ELETRONICA 						= "55";

	/** Conhecimento de Transporte Eletrônico – CT-e - 57 */
	public static final String COD_MOD_CT_ELETRONICO 						= "57";
	
	/**	Recibo Provisório de Serviço */
	public static final String COD_MOD_RPS = "RS";	//	FIXME: Criar script para adicionar RPS, sendo a chave RS (2 Dígitos)

	/**	Outras Receitas				*/
	public static final String NAT_REC_OUTRAS_DESP = "999";
	
	/**
	 * 		Abertura do Arquivo
	 * 
	 *	@param reg Interface do Registro 0100
	 * 	@param ctx Contexto
	 * 	@param dateFrom Data de Abertura
	 * 	@param dateTo Data de Encerramento
	 * 	@param codFin Finalidade do Arquivo / Tipo
	 * 	@param oi Informações da Organização
	 * 	@param trxName Nome da Transação do BD
	 * 	@return
	 * 	@throws Exception
	 */
	public static Reg0000 fillReg0000 (Reg0000 reg, Properties ctx, Timestamp dateFrom, Timestamp dateTo, 
			String codFin, MOrgInfo oi, String indSitEsp, 
			String numRecAnterior, String trxName) throws Exception
	{
		reg.setTIPOESCRIT(codFin);
		reg.setIND_SIT_ESP(indSitEsp);
		reg.setNUM_REC_ANTERIOR(numRecAnterior);
		reg.setCOD_VER(CONTRIB_VERSION);
		//
		return (Reg0000) fillReg0000 ((I_Reg0000) reg, ctx, dateFrom, dateTo, oi, trxName);
	}	//	fillReg0000
	
	/**
	 * 		Abertura do Arquivo
	 * 
	 *	@param reg Interface do Registro 0100
	 * 	@param ctx Contexto
	 * 	@param dateFrom Data de Abertura
	 * 	@param dateTo Data de Encerramento
	 * 	@param codFin Finalidade do Arquivo
	 * 	@param oi Informações da Organização
	 * 	@param trxName Nome da Transação do BD
	 * 	@return
	 * 	@throws Exception
	 */
	public static I_Reg0000 fillReg0000 (I_Reg0000 reg, Properties ctx, Timestamp dateFrom, Timestamp dateTo, 
			MOrgInfo oi, String trxName) throws Exception
	{
		I_W_AD_OrgInfo oiW = POWrapper.create(oi, I_W_AD_OrgInfo.class);
		//
		reg.setDT_INI(dateFrom);
		reg.setDT_FIN(dateTo);
		reg.setNOME(oiW.getlbr_LegalEntity());
		reg.setCNPJ(oiW.getlbr_CNPJ());
		reg.setUF(oiW.getC_Location().getC_Region().getName());		
		//
		MCity city = new MCity(ctx, oiW.getC_Location().getC_City_ID(), trxName);
		reg.setCOD_MUN(city.get_ValueAsString("lbr_CityCode"));	//	FIXME: User Wrapper
		reg.setSUFRAMA(oiW.getlbr_Suframa());

		/**
		 * 	0 - Industria ou Equiparado a Industrial
		 *  1 - Outros
		 */
		//	FIXME: User Wrapper
		reg.setIND_ATIV(oi.get_ValueAsString("lbr_IndAtividade").equals("0") ? "0" : "1");

		return reg;
	}	//	fillReg0000
	
	/**
	 * 		Dados do Contabilista
	 * 
	 * 	@param reg Interface do Registro 0100
	 * 	@param ctx Contexto
	 * 	@param oi Informações da Organização
	 * 	@param trxName Nome da Transação do BD
	 * 	@throws Exception
	 */
	public static I_Reg0100 fillReg0100 (I_Reg0100 reg, Properties ctx, MOrgInfo oi, String trxName) throws Exception
	{
		//	Dados do Contador - FIXME: Ajustar o Wrapper
		MBPartner bpContador = new MBPartner(ctx, oi.get_ValueAsInt("LBR_BP_Accountant_ID"), trxName);
		MBPartnerLocation bpcontLoc = bpContador.getPrimaryC_BPartner_Location();
		MLocation contLoc = new MLocation(ctx, bpcontLoc.getC_Location_ID(), trxName);
	
		// 	Não prosseguir sem os dados essenciais
		if (bpContador == null || bpcontLoc == null || contLoc == null) 
			throw new AdempiereException ("Dados do Contabilista não informado.");

		reg.setNOME(bpContador.getName());
		reg.setCPF(bpContador.get_ValueAsString("lbr_CPF"));	//	FIXME: Ajusta o Wrapper
		reg.setCRC(bpContador.get_ValueAsString("lbr_CRC"));
		reg.setCNPJ(bpContador.get_ValueAsString("lbr_CNPJ"));
		reg.setCEP(contLoc.getPostal());
		reg.setEND(contLoc.getAddress1());
		reg.setNUM(contLoc.getAddress2());
		reg.setCOMPL(contLoc.getAddress4());
		reg.setBAIRRO(contLoc.getAddress3());
		reg.setFONE(bpcontLoc.getPhone());
		reg.setFAX(bpcontLoc.getFax());
		
		//	E-Mail
		if (bpContador.getPrimaryAD_User_ID() > 0) 
			reg.setEMAIL(MUser.get(ctx, bpContador.getPrimaryAD_User_ID()).getEMail());

		//	Código do Município do IBGE
		reg.setCOD_MUN(BPartnerUtil.getCityCode(contLoc));
		
		//	Retorno o mesmo objeto
		return reg;
	}	//	fillReg0100
	
	/**
	 * 		Este registro tem por objetivo definir o regime de incidência a que se 
	 * 	submete a pessoa jurídica (não-cumulativo, cumulativo ou ambos os regimes) 
	 * 	no período da escrituração. No caso de sujeição ao regime não-cumulativo, 
	 * 	será informado também o método de apropriação do crédito incidente sobre operações 
	 * 	comuns a mais de um tipo de receita adotado pela pessoa jurídica para o ano-calendário.
	 * 
	 * @param COD_INC_TRIB Código indicador da incidência tributária no período<br>
	 * 			<li>1 – Escrituração de operações com incidência exclusivamente no 
	 * 									regime não-cumulativo;
	 *			<li>2 – Escrituração de operações com incidência exclusivamente no 
	 *									regime cumulativo;
	 *			<li>3 – Escrituração de operações com incidência nos regimes 
	 *									não-cumulativo e cumulativo.
	 * @param IND_APRO_CRED Código indicador de método de apropriação de créditos comuns
	 * 			<li>1 – Método de Apropriação Direta;
	 *			<li>2 – Método de Rateio Proporcional (Receita Bruta)
	 * @param COD_TIPO_CONT Código indicador do Tipo de Contribuição Apurada no Período
	 * 			<li>1 – Apuração da Contribuição Exclusivamente a Alíquota Básica
	 * 			<li>2 – Apuração da Contribuição a Alíquotas Específicas (Diferenciadas e/ou por 
	 * 									Unidade de Medida de Produto)
	 * @param IND_REG_CUM Código indicador do critério de escrituração e apuração adotado
	 * 			<li>1 – Regime de Caixa – Escrituração consolidada (Registro F500);
	 * 			<li>2 – Regime de Competência - Escrituração consolidada (Registro F550);
	 * 			<li>9 – Regime de Competência - Escrituração detalhada, com base nos registros 
	 * 									dos Blocos “A”, “C”, “D” e “F”
	 * @return Registro 0110
	 * @throws Exception
	 */
	public static Reg0110 getReg0110 (String COD_INC_TRIB, String IND_APRO_CRED, String COD_TIPO_CONT, String IND_REG_CUM) throws Exception
	{
		Reg0110 r0110 = new Reg0110 ();
		r0110.setCOD_INC_TRIB(COD_INC_TRIB);
		r0110.setIND_APRO_CRED(IND_APRO_CRED);
		r0110.setCOD_TIPO_CONT(COD_TIPO_CONT);
		r0110.setIND_REG_CUM(IND_REG_CUM);
		//
		return r0110;
	}	//	getReg0110
	
	/**
	 * 		Este registro tem por objetivo relacionar e informar os estabelecimentos da pessoa jurídica, 
	 * 	no Brasil ou no exterior, que auferiram receitas no período da escrituração, realizaram operações 
	 * 	com direito a créditos ou que sofreram retenções na fonte, no período da escrituração.
	 * 
	 * 	@param ctx Context
	 * 	@param oi Organização
	 * 	@param trxName Transaction Name
	 * 	@return Registro 0140
	 */
	public static Set<Reg0140> getReg0140 (Properties ctx, MOrgInfo[] ois, String trxName)
	{
		Set<Reg0140> r0140L = new HashSet<Reg0140>();
		//
		for (MOrgInfo oi : ois)
		{
			I_W_AD_OrgInfo oiW = POWrapper.create(oi, I_W_AD_OrgInfo.class);
			MLocation location = new MLocation (ctx, oi.getC_Location_ID(), trxName);
			//
			Reg0140 r0140 = new Reg0140();
			r0140.setCNPJ(oiW.getlbr_CNPJ());
			r0140.setCOD_EST(String.valueOf (oi.getAD_Org_ID()));
			r0140.setCOD_MUN(BPartnerUtil.getCityCode (location));
			r0140.setIE(oiW.getlbr_IE());
			r0140.setIM(oiW.getlbr_CCM());
			r0140.setNOME(oiW.getlbr_LegalEntity());
			r0140.setSUFRAMA(oiW.getlbr_Suframa());
			r0140.setUF(oi.getC_Location().getRegionName());
			//
			r0140L.add(r0140);
		}
		return r0140L;
	}	//	getReg0140

	/**
	 * 		Parceiros
	 * 	@return Registros 0150
	 */
	public static Set<I_Reg0150> getReg0150 ()
	{
		return _Reg0150;
	}	//	getReg0150
	
	/**
	 * 		UDMs
	 * 	@return Registros 0190
	 */
	public static Set<I_Reg0190> getReg0190 ()
	{
		return _Reg0190;
	}	//	getReg0190
	
	/**
	 * 		Produtos
	 * 	@return Registros 0200
	 */
	public static Set<I_Reg0200> getReg0200 ()
	{
		return _Reg0200;
	}	//	getReg0200

	/**
	 * 		A010
	 * 	@return Registros A010
	 */
	public static Set<RegA010> getRegA010 ()
	{
		return _RegA010;
	}	//	getRegA010
	
	/**
	 * 		A100
	 * 	@return Registros A100
	 */
	public static Set<RegA100> getRegA100 ()
	{
		return _RegA100;
	}	//	getRegA100
	
	/**
	 * 		C010
	 * 	@return Registros C010
	 */
	public static Set<RegC010> getRegC010 ()
	{
		return _RegC010;
	}	//	getRegC010
	
	/**
	 * 		C100
	 * 	@return Registros C100
	 */
	public static Set<I_RegC100> getRegC100 ()
	{
		return _RegC100;
	}	//	getRegC100
	
	/**
	 * 		C500
	 * 	@return Registros C500
	 */
	public static Set<I_RegC500> getRegC500 ()
	{
		return _RegC500;
	}	//	getRegC500
	
	/**
	 * 		D010
	 * 	@return Registros D010
	 */
	public static Set<RegD010> getRegD010 ()
	{
		return _RegD010;
	}	//	getRegD010
	
	/**
	 * 		D100
	 * 	@return Registros D100
	 */
	public static Set<I_RegD100> getRegD100 ()
	{
		return _RegD100;
	}	//	getRegD100
	
	/**
	 * 		D500
	 * 	@return Registros D500
	 */
	public static Set<I_RegD500> getRegD500 ()
	{
		return _RegD500;
	}	//	getRegC500
	
	/**
	 * 		M100
	 */
	public static RegM100 getRegM100 (Integer period, Integer p_AD_Org_ID)
	{
		RegM100 rM100 = new RegM100();

		MLBRTaxAssessment m_taxAssessment = MLBRTaxAssessment.get(Env.getCtx(), p_AD_Org_ID, "PISPROD", period, null);
		if(m_taxAssessment != null && m_taxAssessment.get_ID() > 0)
		{	
			rM100.setCOD_CRED(m_taxAssessment.getLBR_Cod_OR());
			rM100.setIND_CRED_ORI("0");
			rM100.setVL_BC_PIS(m_taxAssessment.getTotalAmt());
			rM100.setALIQ_PIS(new BigDecimal(0.65));
			rM100.setQUANT_BC_PIS(Env.ZERO);
			rM100.setALIQ_PIS_QUANT(null);
			rM100.setVL_CRED(m_taxAssessment.getTotalCr());
			rM100.setVL_AJUS_ACRES(m_taxAssessment.getAmtByType(X_LBR_TaxAssessmentLine.TYPE_OutrosCréditos).abs());
			rM100.setVL_AJUS_REDUC(m_taxAssessment.getAmtByType(X_LBR_TaxAssessmentLine.TYPE_OutrosDébitos).abs());
			rM100.setVL_CRED_DIF(Env.ZERO);
			rM100.setVL_CRED_DISP(rM100.getVL_CRED().add(rM100.getVL_AJUS_ACRES()).subtract(rM100.getVL_AJUS_REDUC()).subtract(rM100.getVL_CRED_DIF()));
			rM100.setIND_DESC_CRED("0");
			rM100.setVL_CRED_DESC(rM100.getVL_CRED_DISP());
			rM100.setSLD_CRED(Env.ZERO);
		}

		//
		return rM100;
	}	//	getRegM100
	
	/**
	 * 		M200
	 * 	FIXME Deixar M200, M400, M600 e M800 num único método
	 * 	@return Registros M200
	 */
	public static RegM200 getRegM200 ()
	{
		RegM200 rM200 = new RegM200();

		BigDecimal vL_TOT_CONT_CUM_PER = new BigDecimal(0);
			
			rM200.setVL_TOT_CONT_NC_PER(Env.ZERO);//2 COD_CONT = 01, 02, 03, 04, 32 e 71
			rM200.setVL_TOT_CRED_DESC(Env.ZERO); //3
			rM200.setVL_TOT_CRED_DESC_ANT(Env.ZERO);//4
			rM200.setVL_TOT_CONT_NC_DEV(Env.ZERO);//5 (02 – 03 - 04) 
			rM200.setVL_RET_NC(Env.ZERO);//6
			rM200.setVL_OUT_DED_NC(Env.ZERO);//7
			rM200.setVL_CONT_NC_REC(Env.ZERO);//8 (05 – 06 - 07) 
			rM200.setVL_RET_CUM(Env.ZERO);//10
			rM200.setVL_OUT_DED_CUM(Env.ZERO);//11
			
			for (RegM210 rM210: getRegM210())
			{
				vL_TOT_CONT_CUM_PER=vL_TOT_CONT_CUM_PER.add(rM210.getVL_CONT_APUR());
			}
			
			rM200.setVL_TOT_CONT_CUM_PER(vL_TOT_CONT_CUM_PER);//9 COD_CONT = 31, 32, 51, 52, 53, 54 e 72
			rM200.setVL_CONT_CUM_REC(vL_TOT_CONT_CUM_PER);//12
			rM200.setVL_TOT_CONT_REC(vL_TOT_CONT_CUM_PER);//13
			
			for (RegM210 rM210: getRegM210())
				rM200.addRegM210(rM210);
		
		return rM200;
	}	//	getR6M00
	
	/**
	 *		M205
	 *	@return Registro M205
	 */
	public static RegM205 getRegM205(MLBRTaxAssessment m_taxassessment)	
	{
		RegM205 rM205 = new RegM205();
		
		if (!m_taxassessment.get_ValueAsBoolean("LBR_IsCumulativeRegime"))
		{
			//	Campo 08 no Registro M200 referente a Valor Não Cumulativo
			rM205.setNUM_CAMPO("08");
			rM205.setCOD_REC(m_taxassessment.getLBR_Cod_Rec());
			rM205.setVL_DEBITO(m_taxassessment.getLBR_VL_OR());
		}
		else
		{
			//	Campo 12 no Registro M200 referente a Valor Cumulativo
			rM205.setNUM_CAMPO("12");
			rM205.setCOD_REC(m_taxassessment.getLBR_Cod_Rec());
			rM205.setVL_DEBITO(m_taxassessment.getLBR_VL_OR());
		}
		
		return rM205;		
	}	//	getRegM205
	
	public static Set<RegM210> getRegM210 ()
	{
			processRegM210();
			
			Set<RegM210> _RegM210 = new SPEDSet<RegM210> ();
			
			for (BigDecimal key : mapValorItem.keySet())
			{	
				
				RegM210 rM210 = new RegM210 ();
				rM210.setCOD_CONT("51");
				rM210.setVL_REC_BRT(mapValorItem.get(key));
				rM210.setVL_BC_CONT(mapBCTax.get(key));
				rM210.setALIQ_PIS(key);
				rM210.setQUANT_BC_PIS(Env.ZERO);
				rM210.setALIQ_PIS_QUANT(null);
				rM210.setVL_CONT_APUR(mapValorTax.get(key));
				rM210.setVL_AJUS_ACRES(Env.ZERO);
				rM210.setVL_AJUS_REDUC(Env.ZERO);
				rM210.setVL_CONT_DIFER(Env.ZERO);
				rM210.setVL_CONT_DIFER_ANT(Env.ZERO);
				rM210.setVL_CONT_PER(Env.ZERO.add(mapValorTax.get(key)));
				rM210.setRegM211(getRegM211(rM210));
				
				_RegM210.add(rM210);
				
			}
			
			return _RegM210;

	}	//	getRegM210
	
	/**
	 * 		M210
	 * 	@return Registros M210
	 */
	public static void processRegM210 ()
	{
		mapValorItem.clear();
		mapBCTax.clear();
		mapValorTax.clear();
		
		for (I_FiscalDocItem item : items)
			if (TextUtil.match (item.getCST_PIS(), "01", "51", "02", "52", "31", "32"))	
				processRegM210 (item);
	}	//	processRegM210
	
	/**
	 * 		M400
	 * 	@return Registros M400
	 */
	public static void processRegM210 (I_FiscalDocItem item)
	{
		if (item == null)
			return;
		//
		BigDecimal aliqPIS		= item.getALIQ_PIS();
		BigDecimal valorPIS		= item.getVL_PIS();
		BigDecimal valorBCPIS	= item.getVL_BC_PIS();
		BigDecimal valorItem	= item.getVL_ITEM();

		if (aliqPIS.compareTo(Env.ZERO)==1)
		{
			mapValorItem.put(aliqPIS, valorItem);
			mapValorTax.put(aliqPIS, valorPIS);
			mapBCTax.put(aliqPIS, valorBCPIS);
		}
	}	//	processRegM210
	
	/**
	 * 		M211
	 * 	@return Registro M211
	 */
	public static RegM211 getRegM211 (RegM210 rM210)
	{
		RegM211 rM211 = new RegM211();
		
		rM211.setIND_TIP_COOP("99");
		rM211.setVL_BC_CONT_ANT_EXC_COOP(rM210.getVL_BC_CONT());
		rM211.setVL_EXC_COOP_GER(Env.ZERO);
		rM211.setVL_EXC_ESP_COOP(Env.ZERO);
		rM211.setVL_BC_CONT(rM210.getVL_BC_CONT());
		
		return rM211;
	}	//	getR6M00
	
	/**
	 * 		M400
	 * 	@return Registros M400
	 */
	public static void processRegM400 (List<I_FiscalDocItem> items, Map<String, BigDecimal> map)
	{
		map.clear();
		for (I_FiscalDocItem item : items)		
			if (TextUtil.match (item.getCST_PIS(), "04", "05", "06", "07", "08", "09"))	
				processRegM400 (item, map);
	}	//	processRegM400
	
	/**
	 * 		M400
	 * 	@return Registros M400
	 */
	public static void processRegM400 (I_FiscalDocItem item, Map<String, BigDecimal> map)
	{
		if (item == null || map == null)
			return;
		//
		if (TextUtil.match (item.getCST_PIS(), "04", "05", "06", "07", "08", "09"))	//	FIXME
			map.put (item.getCST_PIS(), item.getVL_ITEM());
	}	//	processRegM400
	
	/**
	 * 		M400
	 * 	@return Registros M400
	 */
	public static Set<RegM400> getRegM400 ()
	{	
		processRegM400(items, map);
		
		Set<RegM400> _RegM400 = new SPEDSet<RegM400> ();
		
		for (String key : map.keySet())
		{
			RegM400 rM400 = new RegM400 ();
			rM400.setCST_PIS (key);
			rM400.setVL_TOT_REC (map.get (key));
			//
			RegM410 rM410 = new RegM410 ();
			rM410.setNAT_REC (NAT_REC_OUTRAS_DESP);
			rM410.setVL_REC (map.get (key));
			//
			rM400.addRegM410 (rM410);
			
			_RegM400.add (rM400);
		}
		
		return _RegM400;
	}	//	getRegM400

	/**
	 * 		M500
	 */
	public static RegM500 getRegM500 (Integer period, Integer p_AD_Org_ID)
	{
		RegM500 rM500 = new RegM500();
		
		MLBRTaxAssessment m_taxAssessment = MLBRTaxAssessment.get(Env.getCtx(), p_AD_Org_ID, "PISPROD", period, null);
		if(m_taxAssessment != null && m_taxAssessment.get_ID() > 0)
		{	
			rM500.setCOD_CRED(m_taxAssessment.getLBR_Cod_OR());
			rM500.setIND_CRED_ORI("0");
			rM500.setVL_BC_COFINS(m_taxAssessment.getTotalAmt());
			rM500.setALIQ_COFINS(new BigDecimal(3));
			rM500.setQUANT_BC_COFINS(Env.ZERO);
			rM500.setALIQ_COFINS_QUANT(null);
			rM500.setVL_CRED(m_taxAssessment.getTotalCr());
			rM500.setVL_AJUS_ACRES(m_taxAssessment.getAmtByType(X_LBR_TaxAssessmentLine.TYPE_OutrosCréditos).abs());
			rM500.setVL_AJUS_REDUC(m_taxAssessment.getAmtByType(X_LBR_TaxAssessmentLine.TYPE_OutrosDébitos).abs());
			rM500.setVL_CRED_DIFER(Env.ZERO);
			rM500.setVL_CRED_DISP(rM500.getVL_CRED().add(rM500.getVL_AJUS_ACRES()).subtract(rM500.getVL_AJUS_REDUC()).subtract(rM500.getVL_CRED_DIFER()));
			rM500.setIND_DESC_CRED("0");
			rM500.setVL_CRED_DESC(rM500.getVL_CRED_DISP());
			rM500.setSLD_CRED(Env.ZERO);
		}
		
		//
		return rM500;
	}	//	getRegM100
	
	/**
	 * 		M600
	 * 	FIXME Deixar M200, M400, M600 e M800 num único método
	 * 	@return Registros M200
	 */
	public static RegM600 getRegM600 ()
	{
		RegM600 rM600 = new RegM600();

			BigDecimal vL_TOT_CONT_CUM_PER = new BigDecimal(0);
			
			rM600.setVL_TOT_CONT_NC_PER(Env.ZERO);//2 COD_CONT = 01, 02, 03, 04, 32 e 71
			rM600.setVL_TOT_CRED_DESC(Env.ZERO); //3
			rM600.setVL_TOT_CRED_DESC_ANT(Env.ZERO);//4
			rM600.setVL_TOT_CONT_NC_DEV(Env.ZERO);//5 (02 – 03 - 04) 
			rM600.setVL_RET_NC(Env.ZERO);//6
			rM600.setVL_OUT_DED_NC(Env.ZERO);//7
			rM600.setVL_CONT_NC_REC(Env.ZERO);//8 (05 – 06 - 07) 
			rM600.setVL_RET_CUM(Env.ZERO);//10
			rM600.setVL_OUT_DED_CUM(Env.ZERO);//11
			
			for (RegM610 rM610: getRegM610())
			{
				vL_TOT_CONT_CUM_PER=vL_TOT_CONT_CUM_PER.add(rM610.getVL_CONT_APUR());
			}
			
			rM600.setVL_TOT_CONT_CUM_PER(vL_TOT_CONT_CUM_PER);//9 COD_CONT = 31, 32, 51, 52, 53, 54 e 72
			rM600.setVL_CONT_CUM_REC(vL_TOT_CONT_CUM_PER);//12
			rM600.setVL_TOT_CONT_REC(vL_TOT_CONT_CUM_PER);//13
			
			for (RegM610 rM610: getRegM610())
				rM600.addRegM610(rM610);
		//
		return rM600;
	}	//	getR6M00
	
	/**
	 *		M605
	 *	@return Registro M605
	 */
	public static RegM605 getRegM605(MLBRTaxAssessment m_taxassessment)
	{
		//		Adicionar M605
		//	Contribuição não Cumulativa
		RegM605 rM605 = new RegM605();
		
		if (!m_taxassessment.get_ValueAsBoolean("LBR_IsCumulativeRegime"))
		{
			//	Campo 08 no Registro M600 referente a Valor Não Cumulativo
			rM605.setNUM_CAMPO("08");
			rM605.setCOD_REC(m_taxassessment.getLBR_Cod_Rec());
			rM605.setVL_DEBITO(m_taxassessment.getLBR_VL_OR());			
		}
		else
		{
			//	Campo 12 no Registro M600 referente a Valor Cumulativo
			rM605.setNUM_CAMPO("12");
			rM605.setCOD_REC(m_taxassessment.getLBR_Cod_Rec());
			rM605.setVL_DEBITO(m_taxassessment.getLBR_VL_OR());
		}
		
		return rM605;		
	}	//	getRegM605
	
	/**
	 * 		M210
	 * 	@return Registros M210
	 */
	public static void processRegM610 ()
	{
		mapValorItem.clear();
		mapBCTax.clear();
		mapValorTax.clear();
		
		for (I_FiscalDocItem item : items)
			if (TextUtil.match (item.getCST_COFINS(), "01", "51", "02", "52", "31", "32"))	
				processRegM610 (item);
	}	//	processRegM400
	
	/**
	 * 		M400
	 * 	@return Registros M400
	 */
	public static void processRegM610 (I_FiscalDocItem item)
	{
		if (item == null)
			return;
		//
		BigDecimal aliqCofins		= item.getALIQ_COFINS();
		BigDecimal valorCofins		= item.getVL_COFINS();
		BigDecimal valorBCCofins	= item.getVL_BC_COFINS();
		BigDecimal valorItem		= item.getVL_ITEM();

		if (aliqCofins.compareTo(Env.ZERO)==1)
		{
			mapValorItem.put(aliqCofins, valorItem);
			mapValorTax.put(aliqCofins, valorCofins);
			mapBCTax.put(aliqCofins, valorBCCofins);
		}
	}	//	processRegM210
	
	public static Set<RegM610> getRegM610 ()
	{
			processRegM610();
			
			Set<RegM610> _RegM610 = new SPEDSet<RegM610> ();

			for (BigDecimal key : mapValorItem.keySet())
			{	
				RegM610 rM610 = new RegM610 ();
				rM610.setCOD_CONT("51");
				rM610.setVL_REC_BRT(mapValorItem.get(key));
				rM610.setVL_BC_CONT(mapBCTax.get(key));
				rM610.setALIQ_COFINS(key);
				rM610.setQUANT_BC_COFINS(Env.ZERO);
				rM610.setALIQ_COFINS_QUANT(null);
				rM610.setVL_CONT_APUR(mapValorTax.get(key));
				rM610.setVL_AJUS_ACRES(Env.ZERO);
				rM610.setVL_AJUS_REDUC(Env.ZERO);
				rM610.setVL_CONT_DIFER(Env.ZERO);
				rM610.setVL_CONT_DIFER_ANT(Env.ZERO);
				rM610.setVL_CONT_PER(Env.ZERO.add(mapValorTax.get(key)));
				rM610.addRegM611(getRegM611(rM610));
				
				_RegM610.add(rM610);
			}
			
			return _RegM610;

	}	//	getRegM610
	
	/**
	 * 		M611
	 * 	@return Registro M611
	 */
	public static RegM611 getRegM611 (RegM610 rM610)
	{
		RegM611 rM611 = new RegM611();
		rM611.setIND_TIP_COOP("99");
		rM611.setVL_BC_CONT_ANT_EXC_COOP(rM610.getVL_BC_CONT());
		rM611.setVL_EXC_COOP_GER(Env.ZERO);
		rM611.setVL_EXC_ESP_COOP(Env.ZERO);
		rM611.setVL_BC_CONT(rM610.getVL_BC_CONT());
		
		return rM611;
	}	//	getR6M00
	
	/**
	 * 		M800
	 * 	@return Registros M800
	 */
	public static void processRegM800 (List<I_FiscalDocItem> items, Map<String, BigDecimal> map)
	{
		map.clear();
		for (I_FiscalDocItem item : items)
			if (TextUtil.match (item.getCST_COFINS(), "04","05", "06", "07", "08", "09"))	
				processRegM800 (item, map);
	}
	
	/**
	 * 		M800
	 * 	@return Registros M800
	 */
	public static void processRegM800 (I_FiscalDocItem item, Map<String, BigDecimal> map)
	{
		if (item == null || map == null)
			return;
		//		
		if (TextUtil.match (item.getCST_COFINS(), "04", "05", "06", "07", "08", "09"))
			map.put (item.getCST_COFINS(), item.getVL_ITEM());
	}	//	processRegM800
	
	/**
	 * 		M800
	 * 	FIXME Deixar M400 e M800 num único método
	 * 	@return Registros M800
	 */
	public static Set<RegM800> getRegM800 ()
	{	
		processRegM800(items, map);
		
		for (String key : map.keySet())
		{
			RegM800 rM800 = new RegM800 ();
			rM800.setCST_COFINS (key);
			rM800.setVL_TOT_REC (map.get (key));
			//
			RegM810 rM810 = new RegM810 ();
			rM810.setNAT_REC (NAT_REC_OUTRAS_DESP);
			rM810.setVL_REC (map.get (key));
			//
			rM800.addRegM810 (rM810);
			
			_RegM800.add (rM800);
		}
		
		return _RegM800;
	}	//	getRegM800
	
	/**
	 * 		Retorna o contador dos registros
	 * 
	 * 	@param type SPED ECD, EFD ou Contribuições
	 * 	@param map Mapa com os contadores
	 * 	@return 
	 */
	public static List<I_Reg9900> getReg9900 (int type, Map<String, Integer> map)
	{
		List<I_Reg9900> listReg9900 = new ArrayList<I_Reg9900> ();
		//
		for (Object key : map.keySet())
		{
			I_Reg9900 r9900 = (I_Reg9900) getReg ("Reg9900", type);
			//
			r9900.setREG_BLC ((String) key);
			r9900.setQTD_REG_BLC (new BigDecimal (map.get(key)));
			//
			listReg9900.add (r9900);
		}
		
		//	9900|9001
		I_Reg9900 r9900_9001 = (I_Reg9900) getReg ("Reg9900", type);
		r9900_9001.setREG_BLC ("9001");
		r9900_9001.setQTD_REG_BLC (Env.ONE);
		
		//	9900|9900
		I_Reg9900 r9900_9900 = (I_Reg9900) getReg ("Reg9900", type);
		r9900_9900.setREG_BLC ("9900");
		r9900_9900.setQTD_REG_BLC (new BigDecimal (listReg9900.size() + 4));	// Total + 9900|9001 + 9900|9900 + 9900|9990 + 9900|9999
		
		//	9900|9990
		I_Reg9900 r9900_9990 = (I_Reg9900) getReg ("Reg9900", type);
		r9900_9990.setREG_BLC ("9990");
		r9900_9990.setQTD_REG_BLC (Env.ONE);
		
		//	9900|9999
		I_Reg9900 r9900_9999 = (I_Reg9900) getReg ("Reg9900", type);
		r9900_9999.setREG_BLC ("9999");
		r9900_9999.setQTD_REG_BLC (Env.ONE);
		
		//	Adiciona na lista
		listReg9900.add (r9900_9001);
		listReg9900.add (r9900_9900);
		listReg9900.add (r9900_9990);
		listReg9900.add (r9900_9999);
		//
		return listReg9900;
	}	//	getReg9900
	
	/**
	 * 		Retorna o contador dos registros
	 * 
	 * 	@param type SPED ECD, EFD ou Contribuições
	 * 	@param map Mapa com os contadores
	 * 	@return 
	 */
	public static I_Reg9999 getReg9999 (int type, Map<String, Integer> map)
	{
		I_Reg9999 r9999 = (I_Reg9999) getReg ("Reg9999", type);
		Integer total = map.size() + 7;	// Total + 9001 + 9900|9001 + 9900|9900 + 9900|9990 + 9900|9999 + 9990 + 9999
		//
		for (String key : map.keySet())
			total = total + map.get (key);
		//
		r9999.setQTD_LIN(new BigDecimal(total));
		//
		items.clear();
		
		return r9999;
	}	//	getReg9999
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Códido do País - BRASIL
	 */
	public static String COD_PAIS = "01058"; 
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @param ColumnName
	 * @param isMandatory
	 * @return
	 */
	public static Object checkValue(Object value, String ColumnName, boolean isMandatory) throws Exception
	{
		
		try
		{
			/*
			 * Se o valor for nullo, é inválido
			 */
			if(value == null && isMandatory)
				throw new Exception("null");
			
			/*
			 * Se for String, verificar se é obrigatório e não vazio
			 */
			if(value instanceof String)
			{
				if(isMandatory && ((String) value).trim().isEmpty())
					throw new Exception("Vazio");
				else
					value = "";
			}
			
	
			/*
			 * Se for Bigdecimal, verificar se é diferente de zero
			 */
			if(value instanceof BigDecimal)
			{
				
				if(isMandatory && ((BigDecimal) value).compareTo(Env.ZERO) == 0)
					throw new Exception("Zero");
				else 
					value = Env.ZERO;
				
			}
			
			/*
			 * Se for Bigdecimal, verificar se é diferente de zero
			 */
			if(value instanceof Integer)
			{
				if(isMandatory && ((Integer) value).intValue() == 0)
					throw new Exception("Zero");
				else
					value = 0;
			} 
			
		}
		catch (Exception ex)
		{
			/*
			 * Mostrar ou não nome da coluna no erro
			 */
			if(ColumnName == null || ColumnName.isEmpty())
				throw new Exception("Valor inválido: " + ex.getMessage());
			else
				throw new Exception("Valor inválido para a coluna " + Msg.translate(Env.getCtx(), ColumnName) + ": " + ex.getMessage());
		}
		
		
		/*
		 * retornar o valor validado
		 */
		return value;
	}
	
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @param ColumnName
	 * @param isMandatory
	 * @return String
	 */
	public static String checkValue(String value, String ColumnName, boolean isMandatory) throws Exception
	{
		return (String) checkValue((Object) value, ColumnName, isMandatory);
	}

	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @param ColumnName
	 * @param isMandatory
	 * @return Integer
	 */
	public static Integer checkValue(Integer value, String ColumnName, boolean isMandatory) throws Exception
	{
		return (Integer) checkValue((Object) value, ColumnName, isMandatory);
	}
	
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @param ColumnName
	 * @param isMandatory
	 * @return BigDecimal
	 */
	public static BigDecimal checkValue(BigDecimal value, String ColumnName, boolean isMandatory) throws Exception
	{
		return (BigDecimal) checkValue((Object) value, ColumnName, isMandatory);
	}
	
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @param ColumnName
	 * @return String
	 */
	public static String checkValue(String value, String ColumnName) throws Exception
	{
		return checkValue(value, ColumnName, false);
	}
	
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @param ColumnName
	 * @return BigDecimal
	 */
	public static BigDecimal checkValue(BigDecimal value, String ColumnName) throws Exception
	{
		return checkValue(value, ColumnName, false);
	}
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @param ColumnName
	 * @return Integer
	 */
	public static Integer checkValue(Integer value, String ColumnName) throws Exception
	{
		return checkValue(value, ColumnName, false);
	}
	
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @return String
	 */
	public static String checkValue(String value) throws Exception
	{
		return checkValue(value, null, false);
	}
	
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @return BigDecimal
	 */
	public static BigDecimal checkValue(BigDecimal value) throws Exception
	{
		return checkValue(value, null, false);
	}
	
	
	/**
	 * Varificar se o valor passado do campo é válido
	 * 
	 * Obs.: Usado para validar e lançar erro nos campos do SPED
	 * 
	 * @param value
	 * @return Integer
	 */
	public static Integer checkValue(Integer value) throws Exception
	{
		return checkValue(value, null, false);
	}
	
	
	/**
	 * Retorna as Notas Fiscais por período (compra, venda ou ambos)
	 * @param dateFrom
	 * @param dateTo
	 * @param isSOTrx: true = venda, false = compra, null = ambos
	 * @return MNotaFiscal[]
	 */
	public static MLBRNotaFiscal[] getNFs (Properties ctx, int AD_Org_ID, Timestamp dateFrom, Timestamp dateTo, Boolean isSOTrx, String trxName)
	{
		
		/*
		 * Filtro
		 */
		String whereClause = " AD_Org_ID=? 																	" +
							 " AND (CASE WHEN IsSOTrx='Y' THEN DateDoc 										" +
							 "			ELSE NVL(lbr_DateInOut, DateDoc) END) BETWEEN ? AND ?				";

		
		/*
		 * Filtrar para trazer só NF-e caso seja saída e todas se for entrada
		 */
		whereClause += " AND ((IsSOTrx = 'Y' AND LBR_NFeProt IS NOT NULL) OR (IsSOTrx = 'N')) ";

		/*
		 * Filtrar por Saída e Entrada
		 */
		if (isSOTrx != null)
			whereClause += " AND IsSOTrx='" + (isSOTrx ? "Y" : "N") + "'";

		
		/*
		 * Ordenar por data
		 */
		String orderBy = " (CASE WHEN IsSOTrx='Y' THEN DateDoc ELSE NVL(lbr_DateInOut, DateDoc) END)		";

		
		/*
		 * Query
		 */
		MTable table = MTable.get(Env.getCtx(), MLBRNotaFiscal.Table_Name);
		Query q =  new Query(ctx, table, whereClause.toString(), trxName);
	          q.setOrderBy(orderBy);
		      q.setParameters(new Object[]{Env.getAD_Client_ID(ctx), dateFrom, dateTo});

	    List<MLBRNotaFiscal> list = q.list();
	    MLBRNotaFiscal[] nfs = new MLBRNotaFiscal[list.size()];
	    
	    return list.toArray(nfs);
	    
	}	//	get
	
	
	
	
	
	
}
