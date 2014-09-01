package main;

import java.util.LinkedList;
import java.util.List;

import rendering.RenderingModule;
import blast_it.BlastItModule;

import com.google.inject.AbstractModule;

public class ModuleList {
	public List<AbstractModule> getModules() {
		List<AbstractModule> modules = new LinkedList<AbstractModule>();
		modules.add(new MainModule());
		modules.add(new RenderingModule());
		modules.add(new BlastItModule());
		return modules;
	}
}
