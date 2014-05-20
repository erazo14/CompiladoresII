/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java_cup.runtime.Symbol;

/**
 *
 * @author Armando
 */
public class MyToken extends Symbol{
	public MyToken(int id, int l, int r, int offset, Object o)
	{
		super(id, l, r, o);
		this.offset = offset;
	}

	public MyToken(int id, int l, int r, int offset)
	{
		super(id, l, r);
		this.offset = offset;
	}

	public int offset;
}
