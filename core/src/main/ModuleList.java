package main;

import java.util.LinkedList;
import java.util.List;

import shader.ShaderModule;

import com.google.inject.AbstractModule;

public class ModuleList {
	public List<AbstractModule> getModules() {
		List<AbstractModule> modules = new LinkedList<AbstractModule>();
		modules.add(new MainModule());
		modules.add(new ShaderModule());
		return modules;
	}
}
