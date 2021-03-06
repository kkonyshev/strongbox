package org.carlspring.strongbox.artifact.coordinates;

import org.carlspring.strongbox.data.domain.GenericEntity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author carlspring
 */
public abstract class AbstractArtifactCoordinates
        extends GenericEntity
        implements ArtifactCoordinates
{

    private Map<String, String> coordinates = new LinkedHashMap<>();


    public AbstractArtifactCoordinates()
    {
    }

    public AbstractArtifactCoordinates(Map<String, String> coordinates)
    {
        this.coordinates = coordinates;
    }

    public void defineCoordinates(String... coordinates)
    {
        for (String coordinate : coordinates)
        {
            this.coordinates.put(coordinate, null);
        }
    }

    @Override
    public void dump()
    {
        for (String coordinateName : coordinates.keySet())
        {
            String coordinateValue = coordinates.get(coordinateName);

            System.out.println(coordinateName + " : " + coordinateValue);
        }
    }

    public void defineCoordinate(String coordinate)
    {
        coordinates.put(coordinate, null);
    }

    public String getCoordinate(String coordinate)
    {
        return coordinates.get(coordinate);
    }

    public String setCoordinate(String coordinate,
                                String value)
    {
        return coordinates.put(coordinate, value);
    }

    public Map<String, String> getCoordinates()
    {
        return coordinates;
    }

    public void setCoordinates(Map<String, String> coordinates)
    {
        this.coordinates = coordinates;
    }

    @Override
    public String toString()
    {
        return toPath();
    }


}
