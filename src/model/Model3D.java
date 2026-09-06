package model;

import java.util.List;

import math.Matrix4by4;

public interface Model3D {

	List<Triangle3D> getTriangles();
	void setTransform(Matrix4by4 transform);
	Matrix4by4 getTransform();
	
}
