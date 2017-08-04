<?php
use PHPUnit\Framework\TestCase;
use Src\ApiClass;
/**
* 
*/
class ApiClassTest extends TestCase
{
	
	function testSay()
	{
		$a = new ApiClass();
		$this->assertEquals('back', $a->back());
	}
}