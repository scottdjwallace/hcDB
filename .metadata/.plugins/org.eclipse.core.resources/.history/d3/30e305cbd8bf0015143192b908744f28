package hcdb.address.model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Card {
	
	private final StringProperty playerName;
	private final StringProperty company;
	private final StringProperty series;
    private final IntegerProperty season;
    private final IntegerProperty value;
    private final BooleanProperty rookie;
    private final StringProperty memorabilia;
    
    public Card() {
    	this("", "","", 0, 0, false, "");
    }
    
    public Card (String playerName, String company, String series, int season, int value, boolean rookie, String memorabilia) {
    	this.playerName = new SimpleStringProperty(playerName);
	    this.company = new SimpleStringProperty(company);
	    this.series = new SimpleStringProperty(series);
	    this.season = new SimpleIntegerProperty(season);
	    this.value = new SimpleIntegerProperty(value);
	    this.rookie = new SimpleBooleanProperty(rookie);
	    this.memorabilia = new SimpleStringProperty(memorabilia);
	}

	public String getplayerName() {
		return playerName.get();
	}
	    
	public void setPlayerName(String playerName) {
		this.playerName.set(playerName);
	}
	    	
	public StringProperty playerNameProperty() {
	   	return playerName;
	}

	public String getCompany() {
		return company.get();
	}
	    
	public void setCompany(String company) {
		this.company.set(company);
	}
	    	
	public StringProperty companyProperty() {
	   	return company;
	}

	public String getSeries() {
		return series.get();
	}
	    
	public void setSeries(String series) {
		this.series.set(series);
	}
	    	
	public StringProperty seriesProperty() {
	   	return series;
	}

	public int getSeason() {
		return season.get();
	}
	    
	public void setSeason(int season) {
		this.season.set(season);
	}
	    	
	public IntegerProperty seasonProperty() {
	   	return season;
	}
	
	public int getValue() {
		return value.get();
	}
	    
	public void setValue(int value) {
		this.value.set(value);
	}
	    	
	public IntegerProperty valueProperty() {
	   	return value;
	}
	
	public boolean getRookie() {
		return rookie.get();
	}
	    
	public void setRookie(boolean rookie) {
		this.rookie.set(rookie);
	}
	    	
	public BooleanProperty rookieProperty() {
	   	return rookie;
	}
	
	public String getMemorabilia() {
		return memorabilia.get();
	}
	    
	public void setMemorabilia(String memorabilia) {
		this.memorabilia.set(memorabilia);
	}
	    	
	public StringProperty memorabiliaProperty() {
	   	return memorabilia;
	}

}
