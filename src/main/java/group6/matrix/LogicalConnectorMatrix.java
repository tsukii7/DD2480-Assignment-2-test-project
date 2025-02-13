package group6.matrix;

import group6.common.Constants.ConnectorType;

/**
 * Represents the Logical Connector Matrix (LCM), which defines the logical
 * relationships (e.g., AND, OR, NOTUSED) between pairs of Launch Interceptor
 * Conditions (LICs).
 */
public class LogicalConnectorMatrix {
    private ConnectorType[][] lcm;

    /**
     * Constructs a Logical Connector Matrix with the specified size and
     * initializes all connectors to NOTUSED.
     *
     * @param size the size of the matrix (number of LICs)
     */
    public LogicalConnectorMatrix(int size) {
        lcm = new ConnectorType[size][size];
        initializeMatrix();
    }

    /**
     * Initializes the Logical Connector Matrix by setting all connectors
     * to NOTUSED.
     */
    private void initializeMatrix() {
        for (int i = 0; i < lcm.length; i++) {
            for (int j = 0; j < lcm[i].length; j++) {
                lcm[i][j] = ConnectorType.NOTUSED;
            }
        }
    }

    /**
     * Sets a single connector type for the specified row and column,
     * ensuring symmetry in the matrix.
     *
     * @param row       the row index
     * @param col       the column index
     * @param connector the connector type to set (e.g., AND, OR, NOTUSED)
     */
    public void setConnector(int row, int col, ConnectorType connector) {
        lcm[row][col] = connector;
        lcm[col][row] = connector;
    }

    /**
     * Retrieves the connector type for the specified row and column.
     *
     * @param row the row index
     * @param col the column index
     * @return the connector type at the specified row and column
     */
    public ConnectorType getConnector(int row, int col) {
        return lcm[row][col];
    }

    /**
     * Sets the entire LCM array.
     *
     * @param lcm the LCM as a 2D array of ConnectorType
     */
    public void setLcm(ConnectorType[][] lcm) {
        this.lcm = lcm;
    }
}