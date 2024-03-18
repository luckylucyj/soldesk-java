	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==== 두 겟");
		System.out.println("id: "+ req.getParameter("id"));
		System.out.println("pw: "+ req.getParameter("pw"));