package org.carlspring.strongbox.artifact.coordinates;

import org.carlspring.maven.commons.util.ArtifactUtils;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;

/**
 * @author carlspring
 */
public class MavenArtifactCoordinates extends AbstractArtifactCoordinates
{

    private static final String GROUPID = "groupId";

    private static final String ARTIFACTID = "artifactId";

    private static final String VERSION = "version";

    private static final String CLASSIFIER = "classifier";

    private static final String EXTENSION = "extension";

    private String groupId;

    private String artifactId;

    private String version;

    private String classifier;

    private String extension;


    public MavenArtifactCoordinates()
    {
        defineCoordinates(GROUPID, ARTIFACTID, VERSION, CLASSIFIER, EXTENSION);
    }

    public MavenArtifactCoordinates(String path)
    {
        this(ArtifactUtils.convertPathToArtifact(path));
    }

    public MavenArtifactCoordinates(String... coordinateValues)
    {
        this();

        int i = 0;
        for (String coordinateValue : coordinateValues)
        {
            // Please, forgive the following construct...
            // (In my defense, I felt equally stupid and bad for doing it this way):
            switch (i)
            {
                case 0:
                    setGroupId(coordinateValue);
                    break;
                case 1:
                    setArtifactId(coordinateValue);
                    break;
                case 2:
                    setVersion(coordinateValue);
                    break;
                case 3:
                    setClassifier(coordinateValue);
                    break;
                case 4:
                    setExtension(coordinateValue);
                    break;
                default:
                    break;
            }

            i++;
        }
    }

    public MavenArtifactCoordinates(Artifact artifact)
    {
        this();

        setGroupId(artifact.getGroupId());
        setArtifactId(artifact.getArtifactId());
        setVersion(artifact.getVersion());
        setClassifier(artifact.getClassifier());

        if (artifact.getFile() != null)
        {
            String extension = artifact.getFile().getAbsolutePath();
            extension = extension.substring(extension.lastIndexOf('.'), extension.length());

            setExtension(extension);
        }
        else
        {
            setExtension("jar");
        }
    }

    @Override
    public String toPath()
    {
        try
        {
            return ArtifactUtils.convertArtifactToPath(toArtifact());
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            return getCoordinates().toString();
        }
    }

    public Artifact toArtifact()
    {
        return new DefaultArtifact(getGroupId(),
                                   getArtifactId(),
                                   getVersion(),
                                   "compile",
                                   getExtension(),
                                   getClassifier(),
                                   new DefaultArtifactHandler(getExtension()));
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
        setCoordinate(GROUPID, this.groupId);
    }

    public String getArtifactId()
    {
        return artifactId;
    }

    public void setArtifactId(String artifactId)
    {
        this.artifactId = artifactId;
        setCoordinate(ARTIFACTID, this.artifactId);
    }

    @Override
    public String getId()
    {
        return artifactId;
    }

    @Override
    public void setId(String id)
    {
        setArtifactId(id);
    }

    @Override
    public String getVersion()
    {
        return version;
    }

    @Override
    public void setVersion(String version)
    {
        this.version = version;
        setCoordinate(VERSION, this.version);
    }

    public String getClassifier()
    {
        return classifier;
    }

    public void setClassifier(String classifier)
    {
        this.classifier = classifier;
        setCoordinate(CLASSIFIER, this.classifier);
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
        setCoordinate(EXTENSION, this.extension);
    }

}
